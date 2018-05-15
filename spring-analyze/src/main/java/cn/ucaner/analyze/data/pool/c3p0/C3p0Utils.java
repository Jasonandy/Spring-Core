package cn.ucaner.analyze.data.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
* @Package：cn.ucaner.analyze.data.pool.c3p0   
* @ClassName：C3p0Utils   
* @Description：   <p> C3p0Utils 连接工具</p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午3:28:02   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public class C3p0Utils {

    public static Connection getConnection() throws PropertyVetoException, SQLException, InterruptedException {
        Connection conn = null;
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://47.106.125.14:3306/spingcore?Unicode=true&characterEncoding=utf8&allowMultiQueries=true");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        
        comboPooledDataSource.setInitialPoolSize(4);//池大小

        comboPooledDataSource.setAcquireIncrement(5);// 可以设置连接池的各种属性

        for(int i=0;i<10;i++){
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        
        Thread.sleep(100000);
        return conn;

    }
    
    
}
