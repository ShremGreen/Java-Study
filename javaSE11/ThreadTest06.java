package Thread;
/*
同步机制解决线程安全问题
方法二     继承Thread类
同步方法
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        Window3 t1 = new Window3();
        Window3 t2 = new Window3();
        Window3 t3 = new Window3();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 extends Thread {
    private static int num = 100;
    public void run() {
        while (true) {
            show();
        }
    }
    //private synchronized void show() {//默认是this，但是由于创建了三个对象，实际上仍没有解决。
    private static synchronized void show() {
        if(num > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖" + num + "号票");
            num --;
        } else return;
    }
}