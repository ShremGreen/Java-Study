package Thread;
/*
生产者(Productor)将产品交给店员(CLerk),而消费者(Customer)从店员处取走产品，
店员一次只能持有固定数量的产品(比如:20)，如果生产者试图生产更多的产品，店员
会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品
了，店员会告诉消费者等一下， 如果店中有产品了再通知消费者来取走产品。

分析:
1.是否是多线程问题?是，生产者线程，消费者线程
2.是否有共享数据?是，店员(或产品)
3. 如何解决线程的安全问题?同步机制,有三种方法
4.是否涉及线程的通信?是
 */

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}

//店员类，存放各种方法，并作为基础变量在生产者和消费者之间传递
class Clerk {
    private int num = 0;
    public synchronized void produce() {//同步监视器是this 即Clerk，生产者被锁在这里，而消费者不能进入
        if(num < 20) {
            num ++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + num + "个产品");
            notify();
        } else {//产品数量太多，生产者被强制阻塞，并释放当前同步监视器Clerk
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {//同步监视器是this 即Clerk，消费者被锁在这里，而生产者不能进入
        if(num > 0) {
            System.out.println(Thread.currentThread().getName() + "购买了第" + num + "个产品");
            num --;
            notify();
        } else {//产品数量过少，消费者被强制阻塞，并释放当前同步监视器Clerk
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Consumer c = new Consumer(clerk);
        p.setName("生产者");
        c.setName("消费者");

        p.start();
        c.start();
    }
}
