package Thread;
/*
Thread常用方法：

1. start():启动当前线程;调用当前线程的run()
2. run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
3. currentThread():静态方法，返回执行当前代码的线程
4. getName():获取当前线程的名字
5. setName():设置当前线程的名字
6. yield():释放当前CPU执行的线程
7. join():暂停当前线程，join另外一个线程，待其结束后再继续当前线程
8. stop():强制停止当前线程（已过时）
9. sleep(long millitime):当前线程睡眠（阻塞）指定的毫秒数
10. isAlive():判断线程是否存活
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        AThread at = new AThread("线程一");
       //at.setName("线程一");
        at.start();

        Thread.currentThread().setName("主线程");

        for (int i = 1; i < 100; i ++){
            if(i%2 != 0) {
                System.out.println(Thread.currentThread().getName() + "奇数" + i);
                if(i%10 == 9) {
                    try {
                        at.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(at.isAlive());
    }
}

class AThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i ++){
            if(i%2 == 0) {
                try {
                    sleep(100);//该方法可能异常，但由于父类Thread类中没有定义异常，故不能抛出，而需要try-catch。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "偶数" + i);
                /*if(i%10 == 0) {
                    currentThread().yield();//或者this.yield();
                    //当10的倍数时，释放当前线程，但是下一个执行的线程仍有可能是这个线程。
                }*/
            }
        }
    }

    public AThread(String name) {
        super(name);//super(...)表示调用父类构造方法，对应参数列表（方法重载）
    }
}