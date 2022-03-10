package exercise;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
品牌
增删改查
 */

public class brandTest {
    public static void main(String[] args) throws Exception {
        //1.获取数据库连接池
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\Codes&Notes\\JDBC\\jdbc_demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connect = dataSource.getConnection();

        //2.定义SQL语句
        String sql = "select * from tb_brand;";

        //3.获取PreparedStatement对象
        PreparedStatement preparedStatement = connect.prepareStatement(sql);

        //4.设置参数

        //5.执行SQL
        ResultSet resultSet = preparedStatement.executeQuery();

        //6.处理结果
        Brand brand = null;
        List<Brand> list = new ArrayList<Brand>();
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name" );
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            brand = new Brand();
            brand.setId(id);
            brand.setBrandName (brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered) ;
            brand.setDESCRIPTION(description);
            brand.setSTATUS(status);

            list.add(brand);
        }
        System.out.println(list);

        //关闭流
        resultSet.close();
        preparedStatement.close();
        connect.close();
    }

    @Test
    public void testAdd() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;




        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();


    }



    /**
     * 修改
     * 1. SQL：

     update tb_brand
     set brand_name  = ?,
     company_name= ?,
     ordered     = ?,
     description = ?,
     status      = ?
     where id = ?



     * 2. 参数：需要，所有数据
     * 3. 结果：boolean
     */

    @Test
    public void testUpdate() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;




        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = " update tb_brand\n" +
                "         set brand_name  = ?,\n" +
                "         company_name= ?,\n" +
                "         ordered     = ?,\n" +
                "         description = ?,\n" +
                "         status      = ?\n" +
                "     where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();


    }

    @Test
    public void testDeleteById() throws Exception {
        // 接收页面提交的参数

        int id = 4;


        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = " delete from tb_brand where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数

        pstmt.setInt(1,id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();
    }
}
