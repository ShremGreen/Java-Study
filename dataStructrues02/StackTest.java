package LinkedList;

import java.util.Stack;
/*
栈：
从下往上存入，从上往下取出
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("aa");
        stack.add("bb");
        stack.add("cc");
        while(stack.size() > 0) {
            System.out.println(stack.pop());//cc bb aa
        }
    }
}
