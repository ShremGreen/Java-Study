package Thread;
/*
线程的优先级
有三个常量表示优先级（10档）
MAX_PRIORITY        10
MIN_PRIORITY        1
NORM_PRIORITY       5

可通过get/set方法设置优先级挡位
注意：优先级只是相当于概率，并完全决定先后顺序
 */
public class ThreadDemo04 {
    public static void main(String[] args) {
        BThread bt = new BThread();
        bt.setName("分线程");
        bt.start();
        Thread.currentThread().setName("主线程");

        bt.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(6);

        for (int i = 1; i < 100; i ++){
            if(i%2 == 0) {
                System.out.println(Thread.currentThread().getName() + i + "优先级：" + Thread.currentThread().getPriority());
            }
        }
    }
}

class BThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i ++){
            if(i%2 != 0) {
                System.out.println(Thread.currentThread().getName() + i + "优先级：" + Thread.currentThread().getPriority());
            }
        }
    }
}
