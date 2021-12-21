package Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo1 {
    //没有反射的一般情况
    @Test
    public void test1() {
        Person p1 = new Person("lrc",22);
        p1.getAge();

        p1.show();
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //创建Person对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("lrc",22);
        System.out.println(person);

        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person);
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);//这是个show方法
        //通过反射调用私有结构
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("Tom");
        System.out.println(p1);//Person{name='Tom', age=0}
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"YZB");
        System.out.println(p1);//Person{name='YZB', age=0}
    }
}
