package Project.teamservice;
/*
该类是枚举类
用于存储员工状态
FREE    BUSY    VOCATION
 */
public class Status {
    private final String NAME;//定义一个未赋值的常量
    private Status(String name) {//私有带参构造方法
        this.NAME = name;
    }
    //枚举三个状态量
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");

    public String getNAME() {
        return NAME;
    }
    @Override
    public String toString() {
        return NAME;
    }
}
