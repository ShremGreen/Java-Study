package Enum;
/*
枚举类实现接口
 */
public class EnumDemo03 {
    public static void main(String[] args) {
        Season2 winter = Season2.WINTER;
        System.out.println(winter);
        winter.show();
    }
}

interface in_1 {
    //接口中变量修饰：public static final   接口中方法修饰：public abstract
    //接口中没有方法体
    public abstract void show();
}

enum Season2 implements in_1 {
    SPRING("春","3-5月"){
        @Override
        public void show() {
            System.out.println("春暖花开");
        }
    },
    SUMMER("夏","6-8月"){
        @Override
        public void show() {
            System.out.println("烈日炎炎");
        }
    },
    AUTUMN("秋","9-11月"){
        @Override
        public void show() {
            System.out.println("秋高气爽");
        }
    },
    WINTER("冬","12-2月"){
        @Override
        public void show() {
            System.out.println("寒风凛凛");
        }
    };

    private final String name;
    private final String time;

    private Season2(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time + "\t" + name;
    }
}