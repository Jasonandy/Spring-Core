package cn.ucaner.analyze.data.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {

    public static Connection getConnection() throws PropertyVetoException, SQLException, InterruptedException {
        Connection conn = null;
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://10.4.243.47:3306/waimai_db?Unicode=true&characterEncoding=utf8&allowMultiQueries=true");
        comboPooledDataSource.setUser("q3boy");
        comboPooledDataSource.setPassword("alkf@xpdw");
        comboPooledDataSource.setInitialPoolSize(4);

        comboPooledDataSource.setAcquireIncrement(5);// 可以设置连接池的各种属性

        for(int i=0;i<100;i++){
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
//             conn = comboPooledDataSource.getConnection();
        }

        Thread.sleep(100000);
        return conn;

    }
}
