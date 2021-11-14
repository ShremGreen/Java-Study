package Enum;

import jdk.swing.interop.SwingInterOpUtils;

/*
创建枚举类方法二
使用enum关键字   继承自Enum

Enum类主要方法
values()           返回枚举类型的对象数组。用于遍历
valueOf(String str)把一个字符串转为对应的枚举类对象。
toString()         返回当前枚举类对象常量的名称
 */
public class EnumDemo02 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring.toString());//SPRING，说明父类不是Object（不是地址值）

        //查看父类
        System.out.println(Season1.class.getSuperclass());//java.lang.Enum
        //遍历所有枚举量
        Season1[] values = Season1.values();
        for(int i = 0; i < values.length; i ++) {
            System.out.println(values[i]);
        }
        //values()  遍历多线程的所有状态
        Thread.State[] values1 = Thread.State.values();
        for(int i = 0; i < values1.length; i ++) {
            System.out.println(values1[i]);
        }
        //valueof(String str)
        Season1 spring1 = Season1.valueOf("SPRING");
        System.out.println(spring1);
    }
}

enum Season1 {
    //列出多个枚举值的对象，多个对象间用”，“隔开，
    SPRING("春","3-5月"),
    SUMMER("夏","6-8月"),
    AUTUMN("秋","9-11月"),
    WINTER("冬","12-2月");

    private final String name;
    private final String time;

    private Season1(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    /*@Override
    public String toString() {
        return "Season1{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }*/
}