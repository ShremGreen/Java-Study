package Thread;
/*
需求：
三个窗口共同卖票100张；
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");

        window1.start();
        window2.start();
        window3.start();
        //输出并不是按照顺序的，实际上CPU运算是按照顺序的，但是输出需要时间，因此顺序显示有问题
    }
}

class Window extends Thread {
    private static int num = 100;//静态变量被所有对象成员共享

    @Override
    public void run() {
        while(true) {
            if(num > 0) {
                System.out.println(getName() + "卖票，票号：" + num);
                num --;
            } else return;
        }
    }
    public Window(String name) {
        super(name);
    }
}