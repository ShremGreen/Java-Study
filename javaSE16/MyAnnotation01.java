package Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/*
注解：
示例一：生成文档相关的注解
示例二：在编译时进行格式检查(JDK内置的三个基本注解)
@Override: 表示重写父类方法
@Deprecated: 表示所修饰的元素已过时
@SuppressWarnings: 抑制编译器警告
示例三：跟踪代码依赖性，实现替代配置文件功能

自定义注解：
1.注解声明用@interface关键字
2.内部成员通常用value表示
3.如果注解有成员，在使用时需要指明成员的值
4.可以通过default关键字指定成员的默认值
5.如果自定义注解没有成员，则起标识作用（@Override）

 */
@Inherited
@Repeatable(MyAnnotation03.class)
@Target({TYPE,METHOD})
@Retention(RetentionPolicy.RUNTIME)//运行时有效，运行时保留，程序在运行时
public @interface MyAnnotation01 {
    //String value();

    String value() default "hello";
}

@MyAnnotation01(value = "lrc的Annotation")
class Test02 {
    private String name;
    private String age;

    public Test02() {
    }

    public Test02(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
