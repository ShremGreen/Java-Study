package Collection;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/*
Properties 常用来处理配置文件，key和value都是String类型
 */
public class PropertiesDemo {
    @Test
    public void test() throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println("username = " + username + " password = " + password);
    }
}
