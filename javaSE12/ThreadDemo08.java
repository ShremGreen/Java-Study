package Thread;
/*
线程通信：
方法：
wait()      当前线程进入阻塞状态，并释放同步监视器
notify()    唤醒被wait的一个线程。若有多个线程，首先唤醒优先级高的线程
notifyAll() 唤醒全部被wait的线程
 */
class CountNum implements Runnable {
    private int num = 1;
    @Override
    public void run() {
        while(true) {//B在此等待，A线程正在锁中
            //synchronized (CountNum.class) { //IllegalMonitorStateException，原因：synchronized和notify使用的不是同一个锁
            synchronized (this) {//B线程进入，A线程已经被wait阻塞并释放同步监视器
                this.notify();//唤醒阻塞的A线程，A线程在锁外等待
                if(num <= 100) {
                    /*try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName() + "\t" + num);
                    num ++;
                    try {
                        wait();//B线程被wait阻塞并释放当前同步监视器，A进入
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}
public class ThreadDemo08 {
    public static void main(String[] args) {
        CountNum countNum = new CountNum();

        Thread th1 = new Thread(countNum);
        Thread th2 = new Thread(countNum);

        th1.start();
        th2.start();
    }
}
