package Thread;
/*
卖票案例采用第二种创建多线程的方法

这里就不需要将num变量定为静态，因为仅仅创建了一次实现类，三个创建的线程共用这一个实现类
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        DThread dt = new DThread();
        Thread t1 = new Thread(dt);
        Thread t2 = new Thread(dt);
        Thread t3 = new Thread(dt);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class DThread implements Runnable {
    private int num = 100;
    public int[] arr = new int[3];
    @Override
    public void run() {
        while(true) {
            if(num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，票号：" + num);
                num --;
            } else return;
        }
    }
}