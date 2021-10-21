package JavaSE.API;

import java.util.Scanner;

/*
需求：
利用正则表达式判断手机号正确与否

判断功能
 */
public class RegexDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input:");
        String s = sc.nextLine();

        String regex = "1(3[0-9]|5[0|1|2|3|5|6|7|8|9]|8[0|1|2|3|5|6|7|8|9])\\d{8}";
        //String regex = "1(3[0-9]|5[0|1|2|3|5|6|7|8|9]|8[0|1|2|3|5|6|7|8|9])\\d{8}";
        boolean b = s.matches(regex);
        System.out.println(b);
    }
}
