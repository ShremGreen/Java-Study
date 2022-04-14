package demo.test;

import beanLife.Life;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.applet.AppletListener;

public class LifeDemo {
    @Test
    public void lifeTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean04.xml");
        Life order = context.getBean("order", Life.class);
        System.out.println("第四步 获取创建bean的实例对象");
        System.out.println(order);

        //手动让bean实例销毁
        ((ClassPathXmlApplicationContext) context).close();

/*
第一步 执行无参数构造创建 bean 实例
第二步 调用 set 方法设置属性值
第三步 执行初始化的方法
第四步 获取创建bean的实例对象
beanLife.Life@74ad1f1f
第五步 执行销毁的方法
*/

    }
}
