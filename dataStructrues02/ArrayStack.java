package Stack;

import java.util.Scanner;

class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        Scanner sc = new Scanner(System.in);
        int key = ' ';
        boolean loop = true;
        while(loop) {
            System.out.println("1   遍历显示");
            System.out.println("2   入栈");
            System.out.println("3   出栈");
            System.out.println("4   退出");
            key = sc.nextInt();
            switch(key) {
                case 1:
                    stack.list();
                    break;
                case 2:
                    try {
                        System.out.println("请输入要放入的值");
                        int value = sc.nextInt();
                        stack.push(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        int pop = stack.pop();
                        System.out.println("出栈数据：" + pop);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化栈数组
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if(isFull()) {
            throw new RuntimeException("栈满，不能存放数据");
        }
        top ++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈空，请先存放数据");
        }
        int value = stack[top];
        stack[top] = 0;
        top --;
        return value;
    }

    //遍历
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，请先存放数据");
            return;
        }
        for(int i = top; i > -1; i --) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}


