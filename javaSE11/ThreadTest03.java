package Thread;
/*
线程的同步问题
卖票案例中加入sleep方法后，会出现两种新的状况
1.三个窗口同时卖出同一票号
2.出现0号甚至负号票

原因：
线程在被阻塞时，另外的两个线程会在其被阻塞期间完成票号读取，并加入阻塞的队列，此时，三个窗口都显示卖出同一票号，但实际上票数已经少了三张。
而在票数殆尽时，三个线程若仍出现上述现象，则会造成0号票甚至负号票的卖出

解决方法：
同步机制解决线程的安全问题
方法一：
synchronized(同步监视器) {
    需要被同步的代码
}
同步代码：即操作共享数据的代码，多个线程共同操作的变量即为共享数据
同步监视器：俗称 锁。任何一个对象都可以作为锁。但是要求所有线程必须共用一个锁。

同步方法优势：操作同步代码块时，只能有一个线程参与，相当于单线程。安全性高，但是降低了效率。

 */
public class ThreadTest03 {
    public static void main(String[] args) {
        EThread dt = new EThread();
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

class EThread implements Runnable {
    private int num = 100;
    Object obj = new Object();//任意创建一个对象，作为锁
    @Override
    public void run() {
        //synchronized (obj) {//此时包含代码过多，相当于永远只用一个线程卖票
        while(true) {
            //synchronized (obj) {//方法1     正确
            synchronized (this) {//方法2      正确  返回当前对象
                if (num > 0) {

                    System.out.println(Thread.currentThread().getName() + "卖票，票号：" + num);
                    num--;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else return;
            }
        }
    }
}

