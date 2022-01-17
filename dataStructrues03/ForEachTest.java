package Stack;

import org.junit.Test;

import java.util.Stack;

public class ForEachTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int[] arr = {1,2,3,4,5};

        /*for(int ele : stack) {
            System.out.println(ele);
            System.out.println(stack.peek());
        }*/

        for(int ele : arr) {
            System.out.println(ele);
        }
    }
    @Test
    public void test() {
        String str1 = "lrc";
        String str2 = "java";
        System.out.println(str1 == "lrc");
        System.out.println(str1.equals("lrc"));
    }
}
