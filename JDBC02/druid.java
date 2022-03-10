import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*

*/
public class druid {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\Codes&Notes\\JDBC\\jdbc_demo\\src\\druid.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接 Connection
        Connection connect = dataSource.getConnection();

        System.out.println(connect);
        //System.out.println(System.getProperty("user.dir"));
    }
}
