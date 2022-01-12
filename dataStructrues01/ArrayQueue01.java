package Queue;

import java.util.Scanner;
/*
基础队列模拟
用一维数组模拟最基础的队列，
头指针front：首元素的前一个位置
尾指针rear：尾元素的位置
队列满的条件

该队列只能按顺序存取一次，指针位置不会循环变化，不能复用

 */
class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue01 arrayQueue = new ArrayQueue01(3);
        Scanner sc = new Scanner(System.in);
        char input = ' ';
        input = sc.next().charAt(0);
        boolean loop = true;
        while(loop) {
            switch(input) {
                case 's':
                    try {
                        arrayQueue.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        loop = false;
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                case 'a':
                    try {
                        int value = sc.nextInt();
                        arrayQueue.addQueue(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                        loop = false;
                    }
                    break;
                case 'g':
                    try {
                        int d = arrayQueue.getQueue();
                        System.out.println("取出数据为：" + d);
                    } catch (Exception e) {
                        e.printStackTrace();
                        loop = false;
                    }
                    break;
                case 'h':
                    System.out.println("头数据为：" + arrayQueue.headQueue());
                    break;
                default:
                    break;
            }
        }
    }
}

//使用数组模拟队列编写一个ArrayQueue类
public class ArrayQueue01 {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //构造方法
    public ArrayQueue01(int maxSize) {
        this.maxSize = maxSize;
        front = -1;//头指针,首元素的前一个位置
        rear = -1;//尾指针,末尾元素的位置
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int data) {
        if(isFull()) {
            throw new RuntimeException("队列已满");
        }
        rear ++;//尾指针后移
        arr[rear] = data;
    }

    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front ++;
        return arr[front];
    }

    public void show() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for(int i = 0; i < arr.length; i ++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}

