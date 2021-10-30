package Thread;
/*
多线程的创建
方式一
创建一个Thread类的子类；重写run方法；创建子类对象并调用start方法
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();//启动当前线程，调用当前线程的run方法

        myThread.run();//单线程，其实就是在main方法中直接调用run方法
        //输出奇数
        for (int i = 1; i < 100; i ++){
            if(i%2 != 0) {
                System.out.println(Thread.currentThread().getName() + "奇数" + i);
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {//输出偶数
        for (int i = 1; i < 100; i ++){
            if(i%2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数" + i);
            }
        }
    }
}