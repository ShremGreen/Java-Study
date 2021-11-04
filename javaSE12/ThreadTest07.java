package Thread;

import java.util.concurrent.locks.ReentrantLock;

/*
应用需求：
两个用户共同向一个银行账户里分别存钱三次，每次存钱后都输出当前余额。
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        Account acc = new Account();
        User u1 = new User(acc);
        User u2 = new User(acc);

        u1.setName("甲");
        u2.setName("乙");

        u1.start();
        u2.start();
    }
}

class Account {
    private double money;
    ReentrantLock lock = new ReentrantLock();

    public Account() {
    }

    //方法一   synchronized代码块
    /*public synchronized void deposit(double cash) {
        this.money += cash;
        System.out.println(Thread.currentThread().getName() + ":存款1000￥。账户余额：" + money);
    }*/

    //方法二   synchronized方法
    /*public void deposit(double cash) {
        synchronized(Account.class) {
            this.money += cash;
            System.out.println(Thread.currentThread().getName() + ":存款1000￥。账户余额：" + money);
        }
    }*/

    //方法三   lock锁方法
    public void deposit(double cash) {
        try {
            lock.lock();
            this.money += cash;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":存款1000￥。账户余额：" + money);
        } finally {
            lock.unlock();
        }
    }
}

class User extends Thread {
    private Account acc;//用户有自己的私有账户

    public User(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i ++) {
            acc.deposit(1000);
        }
    }
}