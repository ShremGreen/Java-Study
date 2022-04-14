package demo.test;

import demo.Orders;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2 {
    @Test
    public void testConstruct() {
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        //获取配置创建的对象
        Orders order = context.getBean("orders", Orders.class);

        System.out.println(order);
    }
}
