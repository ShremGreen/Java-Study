package AOP.aopAnno;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean07.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
