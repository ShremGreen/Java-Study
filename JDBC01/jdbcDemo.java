import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

/*
JDBC 快速入门
 */

public class jdbcDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");//需要抛异常

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "951esz753";
        Connection connect = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql = "update bank set money = 1596 where id = 1";

        //获取执行sql的对象Statement
        Statement state = connect.createStatement();

        //执行sql
        int count = state.executeUpdate(sql);

        //处理结果
        System.out.println(count);

        //释放资源
        state.close();
        connect.close();
    }
}
