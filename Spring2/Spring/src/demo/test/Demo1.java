package demo.test;

import demo.eDemo01;
import demo.eDemo02;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
测试类
*/
public class Demo1 {
    @Test
    public void testAdd() {
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");

        //获取配置创建的对象
        eDemo02 book = context.getBean("book", eDemo02.class);

        System.out.println(book);//demo.eDemo02@1b26f7b2
        book.test();//活着123余华
    }
}
