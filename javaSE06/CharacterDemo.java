package JavaSE.API;

import java.util.Scanner;

/*
public static boolean isUpperCase (char ch) :   判断给定的字符是否是大写字符
public static boolean isLowerCase (char ch) :   判断给定的字符是否是小写字符
public static boolean isDigit (char ch) :       判断给定的字符是否是数字字符
public static char toUpperCase (char ch) :      把给定的字符转换为大写字符
public static char toLowerCase (char ch) :      把给定的字符转换为小写字符

判断输入字符串的大写小写和数字个数
 */
public class CharacterDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input:");
        String s = sc.nextLine();
        int x = 0;
        int y = 0;
        int z = 0;

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i ++) {
            if(Character.isUpperCase(arr[i])) {
                x ++;
            } else if(Character.isLowerCase(arr[i])) {
                y ++;
            } else if(Character.isDigit(arr[i])) {
                z ++;
            }
        }
        System.out.println(x + "\n" + y + "\n" + z);
    }
}
