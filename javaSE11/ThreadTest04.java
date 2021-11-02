package Thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        Window1 w1 = new Window1("窗口1");
        Window1 w2 = new Window1("窗口2");
        Window1 w3 = new Window1("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
class Window1 extends Thread {
    private static int num = 100;//静态变量被所有对象成员共享
    static Object obj = new Object();

    @Override
    public void run() {
        while(true) {
            //synchronized(obj) {//方法1          正确
            //synchronized (this) {//方法2        错误
            synchronized(Window1.class) {//方法3  正确  调用当前类做对象
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "卖票，票号：" + num);
                    num--;
                } else return;
            }
        }
    }
    public Window1(String name) {
        super(name);
    }
}