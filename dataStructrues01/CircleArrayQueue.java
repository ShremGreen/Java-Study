package Queue;

import java.util.Scanner;

/*
环形队列：首位相连
1.front:指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素.front的初始值=0
2.rear:指向队列的最后一个元素的后一个位置.因为希望空出一个空间做为约定.rear的初始值=0
3.当队列满的条件:（rear + 1) % maxSize = front
4.对队列为空的条件:rear == front
5.当我们这样分析，队列中有效的数据的个数(rear + maxSize - front) % maxSize

 */
class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        Scanner sc = new Scanner(System.in);
        int key = 0;
        boolean loop = true;
        while(loop) {
            System.out.println("1--显示队列\t2--添加元素\t3--获取元素\t4--显示头元素");
            key = sc.nextInt();
            switch(key) {
                case 1:
                    System.out.println("显示队列：");
                    circleArrayQueue.showArr();
                    break;
                case 2:
                    try {
                        System.out.println("请输入要添加的元素：");
                        int value = sc.nextInt();
                        circleArrayQueue.addValue(value);
                        System.out.println("添加成功");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("取出元素：");
                        int value1 = circleArrayQueue.getValue();
                        System.out.println(value1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("显示头元素为：");
                    circleArrayQueue.headValue();
                    break;
                default:
                    break;
            }
        }

    }
}

public class CircleArrayQueue {
    private int front = 0;
    private int rear = 0;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addValue(int value) {
        if(isFull()) {
            throw new RuntimeException("环形队列已满");
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;//环形队列首尾相连，取模是为了防止数组越界
    }

    public int getValue() {
        if(isEmpty()) {
            throw new RuntimeException("环形队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;//防止数组越界
        return value;
    }

    public void showArr() {
        if(isEmpty()) {
            System.out.println("环形队列为空");
        }
        int num = (rear - front + maxSize) % maxSize;
        for(int i = front; i < front + num; i ++) {
            System.out.print(arr[i % maxSize] + "\t");
        }
        System.out.println();
        System.out.println("头指针：" + front + "\t尾指针：" + rear);
    }

    public void headValue() {
        if(isEmpty()) {
            System.out.println("环形队列为空");
        }
        System.out.println("头指针为" + front + "\t值为" + arr[front]);
    }
}
