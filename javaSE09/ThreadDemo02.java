package Thread;

public class ThreadDemo02 {
    public static void main(String[] args) {
        new Thread(){//匿名内部类
            public void run() {
                for (int i = 1; i < 100; i ++){
                    if(i%2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "偶数" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run() {
                for (int i = 1; i < 100; i ++){
                    if(i%2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "奇数" + i);
                    }
                }
            }
        }.start();
    }
}
