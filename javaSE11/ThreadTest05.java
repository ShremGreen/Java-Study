package Thread;
/*
同步机制解决线程的安全问题
方法二     实现Runnable接口
同步方法 关键字synchronized

与方法一的区别，方法一使用代码块，而如果同步代码是整个方法时，用方法二更简单
 */
public class ThreadTest05 {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable {
    private int num = 100;
    public void run() {
        while(true) {
            show();
        }
    }

    private synchronized void show() {//这里相对于第一种同步代码块的方法，同步监视器是this
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