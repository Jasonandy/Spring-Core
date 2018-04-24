package cn.ucaner.analyze.data.pool.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DruidUtil {

    public static Connection getConnection() throws PropertyVetoException, SQLException, InterruptedException {
        Connection conn = null;
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://10.4.243.47:3306/waimai_db?Unicode=true&characterEncoding=utf8&allowMultiQueries=true");
        druidDataSource.setUsername("q3boy");
        druidDataSource.setPassword("alkf@xpdw");
        druidDataSource.setFilters("log4j");



        conn = druidDataSource.getConnection();

        return conn;

    }
}
