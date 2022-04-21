package demo.test;

import autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireDemo {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean06.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
