package IDEA_code;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String s = sc.nextLine();
        System.out.println(reverseArr(s));
    }

    public static String reverseArr(String s) {
        String s1 = "";
        for(int i = s.length(); i > 0; i --) {
            s1 = s1 + s.charAt(i - 1);
        }
        return s1;
    }
}

