package Thread;
/*
单例模式（八种）
特点：
1.某个类只有一个实例；
2.且自行实例化；
3.单例类必须给其他对象提供该实例

在计算机系统中，单例模式经常被设计为资源管理器。
单例模式保证了系统全局对象的唯一性。
如：系统启动读取配置文件就需要单例模式来保证配置的唯一性

初级： 饿汉式和懒汉式
饿汉式：类在被加载时就自行初始化。没有起到Lazy Loading的效果。若自始至终未使用该实例，则会造成资源浪费。
懒汉式：起到了Lazy Loading的效果。但只能单线程，多线程不安全。
 */
class Singleton01 {
    //懒汉式   一（线程不安全，不可用）
    private static Singleton01 singleton01;//声明一个静态变量，因为只用一个实例
    public Singleton01() { }

    public static Singleton01 getInstance() {//声明一个静态方法，用于自行创建一个实例
        if(singleton01 == null) {
            singleton01 = new Singleton01();
        }
        return singleton01;
    }
    //问题：多线程时可能会出现多个线程同时执行if判断，从而产生多个对象，与单例模式初衷不符
}

class Singleton02 {
    //懒汉式   二（线程安全，不可用）
    private static Singleton02 singleton02;
    public Singleton02() { }

    public static synchronized Singleton02 getInstance() {
        if(singleton02 == null) {
            singleton02 = new Singleton02();
        }
        return singleton02;
    }
    //问题：虽然采用同步机制，但是同时带来了效率问题。（每个线程都在此依次等候）
}

class Singleton03 {
    //改进懒汉式（双重加载）   可用
    private static Singleton03 singleton03;
    public Singleton03() { }

    public static synchronized Singleton03 getInstance() {
        if(singleton03 == null) {//第一层判断    第一个线程锁在里面，并建立实例
            synchronized (Singleton03.class) {
                if(singleton03 == null) {//第二层循环    防止有多个线程依次进入
                    singleton03 = new Singleton03();
                }
            }
        }
        return singleton03;
    }
    //优点：只需要实例化一次后，后面所有的线程在执行时都会跳过同步机制，节省了时间
    //线程安全，高效，延迟加载
}

class Singleton04 {
    //饿汉式改进版（静态内部类） 可用
    private Singleton04() { }

    private static class Singleton04Instance {//静态内部类
        private static final Singleton04 INSTANCE = new Singleton04();
    }

    public static Singleton04 getInstance() {//直接
        return Singleton04Instance.INSTANCE;
    }
    //优点：静态内部类中自行实例化，使得外界可以直接调用getInstance方法来自行驱动
    //线程安全，高效，延迟加载
}