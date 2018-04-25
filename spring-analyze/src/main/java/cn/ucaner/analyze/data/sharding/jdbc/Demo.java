package cn.ucaner.analyze.data.sharding.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import com.dangdang.ddframe.rdb.sharding.api.rule.BindingTableRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.jdbc.core.datasource.ShardingDataSource;

public class Demo {


    // CHECKSTYLE:OFF
    public static void main(final String[] args) throws Exception {
        // CHECKSTYLE:ON
        DataSource dataSource = getShardingDataSource();
        createTable(dataSource);
        insertData(dataSource);
        printSimpleSelect(dataSource);
        System.out.println("--------------");
        printGroupBy(dataSource);
        System.out.println("--------------");
        printHintSimpleSelect(dataSource);
        dropTable(dataSource);
    }

    private static void createTable(final DataSource dataSource) throws SQLException {
        executeUpdate(dataSource, "CREATE TABLE IF NOT EXISTS `t_order` (`order_id` INT NOT NULL, `user_id` INT NOT NULL, `status` VARCHAR(50), PRIMARY KEY (`order_id`))");
        executeUpdate(dataSource, "CREATE TABLE IF NOT EXISTS `t_order_item` (`item_id` INT NOT NULL, `order_id` INT NOT NULL, `user_id` INT NOT NULL, PRIMARY KEY (`item_id`))");
    }

    private static void insertData(final DataSource dataSource) throws SQLException {
        for (int orderId = 1000; orderId < 1010; orderId++) {
            executeUpdate(dataSource, String.format("INSERT INTO `t_order` (`order_id`, `user_id`, `status`) VALUES (%s, 10, 'INIT')", orderId));
            executeUpdate(dataSource, String.format("INSERT INTO `t_order_item` (`item_id`, `order_id`, `user_id`) VALUES (%s01, %s, 10)", orderId, orderId));
        }
        for (int orderId = 1100; orderId < 1110; orderId++) {
            executeUpdate(dataSource, String.format("INSERT INTO `t_order` (`order_id`, `user_id`, `status`) VALUES (%s, 11, 'INIT')", orderId));
            executeUpdate(dataSource, String.format("INSERT INTO `t_order_item` (`item_id`, `order_id`, `user_id`) VALUES (%s01, %s, 11)", orderId, orderId));
        }
    }

    private static void printSimpleSelect(final DataSource dataSource) throws SQLException {
        String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, 10);
            preparedStatement.setInt(2, 1001);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                    System.out.println(rs.getInt(3));
                }
            }
        }
    }

    private static void printGroupBy(final DataSource dataSource) throws SQLException {
        String sql = "SELECT o.user_id, COUNT(*) FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id GROUP BY o.user_id";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("user_id: " + rs.getInt(1) + ", count: " + rs.getInt(2));
            }
        }
    }

    private static void printHintSimpleSelect(final DataSource dataSource) throws SQLException {
        String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id";
        try (
                HintManager hintManager = HintManager.getInstance();
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            hintManager.addDatabaseShardingValue("t_order", "user_id", 10);
            hintManager.addTableShardingValue("t_order", "order_id", 1001);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                    System.out.println(rs.getInt(3));
                }
            }
        }
    }

    private static ShardingDataSource getShardingDataSource() throws SQLException {
        DataSourceRule dataSourceRule = new DataSourceRule(createDataSourceMap());
        TableRule orderTableRule = TableRule
                .builder("t_order")
                .actualTables(Arrays.asList("t_order_0", "t_order_1")).dataSourceRule(dataSourceRule).build();
        TableRule orderItemTableRule = TableRule
                .builder("t_order_item")
                .actualTables(Arrays.asList("t_order_item_0", "t_order_item_1")).dataSourceRule(dataSourceRule).build();
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(Arrays.asList(orderTableRule, orderItemTableRule))
                .bindingTableRules(Collections.singletonList(new BindingTableRule(Arrays.asList(orderTableRule, orderItemTableRule))))
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm())).build();
        return new ShardingDataSource(shardingRule);
    }

    private static Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>(2);
        result.put("ds_jdbc_0", createDataSource("sharding_0"));
        result.put("ds_jdbc_1", createDataSource("sharding_1"));
        return result;
    }

    private static DataSource createDataSource(final String dataSourceName) {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://47.106.125.14/%s", dataSourceName));
        result.setUsername("root");
        result.setPassword("123456");
        return result;
    }


    private static void dropTable(final DataSource dataSource) throws SQLException {
        executeUpdate(dataSource, "DROP TABLE `t_order_item`");
        executeUpdate(dataSource, "DROP TABLE `t_order`");
    }

    private static void executeUpdate(final DataSource dataSource, final String sql) throws SQLException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    }
}
