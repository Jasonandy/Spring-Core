package cn.ucaner.analyze.data.pool.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Client {

    public static void main(String[] args) throws PropertyVetoException, SQLException, InterruptedException {

        Connection conn = C3p0Utils.getConnection();

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        Statement stmt = conn.createStatement();


        String sql = "INSERT INTO jdbc_user " +"(user_name,sex,age,email,phone,version,last_modify_time,create_time)"+
                "VALUES ('springCore',null,null,'jasonandy@hotmail.com',null,null,null,null)";
        stmt.executeUpdate(sql);
        Thread.sleep(10);

        conn.close();


    }
}
