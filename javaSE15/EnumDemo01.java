package Enum;

import org.junit.Test;
/*
自定义枚举类  继承自Object类
1.首先private final修饰枚举类中需要被枚举的量
2.创建私有的带参构造方法
3.内部自行初始化
4.重写toString()
 */
public class EnumDemo01 {
    @Test
    public void test() {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);
    }
}

class Season {
    //1.private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.声明带参构造，并私有化
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.定义枚举量,在枚举类内部自行实例化
    public static final Season SPRING = new Season("春","3-5月");
    public static final Season SUMMER = new Season("夏","6-8月");
    public static final Season AUTUMN = new Season("秋","9-11月");
    public static final Season WINTER = new Season("冬","12-2月");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}