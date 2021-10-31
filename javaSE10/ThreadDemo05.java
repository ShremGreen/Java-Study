package Thread;
/*
创建多线程的第二种方法
创建实现runnable接口的类，并实现run抽象方法
创建实现类对象和Thread类对象，并将其作为参数传递到Thread的构造方法中
通过Thread类调用start方法
 */
public class ThreadDemo05 {
    public static void main(String[] args) {
        CThread ct = new CThread();
        Thread t = new Thread(ct);
        t.start();//启动线程，通过target调用runnable接口内被重写的run方法
    }
}

class CThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 100; i ++){
            if(i%2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数" + i);
            }
        }
    }
}