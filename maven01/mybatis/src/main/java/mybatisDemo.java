import POJO.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

/*
mybatis 入门代码
*/
public class mybatisDemo {
    public static void main(String[] args) throws Exception {
        //加载mybatis配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        List<user> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);

        //释放资源
        sqlSession.close();
    }
}
