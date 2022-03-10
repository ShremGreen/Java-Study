import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
/*
sql注入
实质上是利用字符串的拼接机制，人为制造的漏洞
 */
public class preparedStatement {
    /***
     * SQL注入 示例
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///mydatabase?useSSL=false";
        String username = "root";
        String password = "951esz753";
        Connection connect = DriverManager.getConnection(url,username,password);

        String name = "lrc";
        String pword = "'or'1'='1";
        String sql = "select * from login where username = '"+name+"' and password = '"+pword+"'";
        System.out.println(sql);//select * from login where username = 'lrc' and password = ''or'1'='1'

        Statement statement = connect.createStatement();

        ResultSet result = statement.executeQuery(sql);

        if(result.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        result.close();
        statement.close();
        connect.close();
    }

    /***
     * 通过PreparedStatement防止SQL注入
     * @throws Exception
     */
    @Test
    public void solution() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///mydatabase?useSSL=false";
        String username = "root";
        String password = "951esz753";
        Connection connect = DriverManager.getConnection(url,username,password);

        String name = "lrc";
        String pword = "123456";//
        String sql = "select * from login where username = ? and password = ?";

        PreparedStatement preparedStatement = connect.prepareStatement(sql);

        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pword);

        ResultSet result = preparedStatement.executeQuery();

        if(result.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        result.close();
        preparedStatement.close();
        connect.close();
    }
}
