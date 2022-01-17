package Recursion;

public class RecursionDemo1 {
    public static void main(String[] args) {
        method(5);
    }
    public static void method(int num) {
        if(num > 2) {
            method(num - 1);
        }
        System.out.println(num);
    }
}
