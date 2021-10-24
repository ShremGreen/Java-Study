package JavaSE.Exception;

import java.util.Date;
import java.util.Scanner;
/*
常见的异常类型
 */
public class ExceptionDemo01 {
    public static void main(String[] args) {
        //空指针异常
        int[] arr = null;
        System.out.println(arr[0]);//java.lang.NullPointerException
        String s = null;
        System.out.println(s.charAt(0));//java.lang.NullPointerException

        //角标越界
        int[] a = new int[3];
        System.out.println(a[3]);//ArrayIndexOutOfBoundsException
        String s1 = "lrc";
        System.out.println(s1.charAt(3));//StringIndexOutOfBoundsException

        //类型转换异常
        Object obj = new Date();
        String s2 = (String)obj;//ClassCastException

        //数值格式异常
        String s3 = "123";
        s3 = "lrc";
        int num = Integer.parseInt(s3);//NumberFormatException

        //录入类型异常
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();//如果录入类型非int  InputMismatchException
        
        //运算异常
        int x = 0;
        int y = 3;
        System.out.println(y/x);//ArithmeticException
    }
}
