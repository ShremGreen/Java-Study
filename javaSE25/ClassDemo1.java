package Reflection;

import org.junit.Test;
/*
Class实例化
1.调用运行时类的属性   .class
2.调用运行时类的对象   getClass()
3.调用Class类的静态方法   forName()
*4.使用类的加载器     ClassLoader
 */
public class ClassDemo1 {
    @Test
    public void test() throws ClassNotFoundException {
        //实例化方法1    调用运行时类的属性   .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //实例化方法2    调用运行时类的对象   getClass()
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2);

        //实例化方法3    调用Class类的静态方法   forName()
        Class clazz3 = Class.forName("java.lang.Object");
        System.out.println(clazz3);

        //实例化方法4    使用类的加载器     ClassLoader
        ClassLoader classLoader = ClassDemo1.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("Reflection.Person");
        System.out.println(clazz4);

        //test
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
    }
}
