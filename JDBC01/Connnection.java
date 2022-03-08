import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
需要将 sql1 和 sql2 合为一组事务
可以同时执行成功或执行失败

Connection
1.获取执行sql的对象
2.管理事务
 */
public class Connnection {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");//需要抛异常

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "951esz753";
        Connection connect = DriverManager.getConnection(url,username,password);

        String sql1 = "update bank set money = 3200 where id = 1";
        String sql2 = "update bank set money = 2300 where id = 2";

        Statement state = connect.createStatement();

        try {
            //开启事务
            connect.setAutoCommit(false);

            int count1 = state.executeUpdate(sql1);
            System.out.println(count1);
            int i = 2/0;
            int count2 = state.executeUpdate(sql2);
            System.out.println(count2);

            //提交事务
            connect.commit();
        } catch (SQLException throwables) {
            //回滚事务
            connect.rollback();

            throwables.printStackTrace();
        }

        state.close();
        connect.close();
    }
}
