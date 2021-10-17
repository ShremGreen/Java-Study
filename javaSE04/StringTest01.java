package JavaSE.API;

import java.util.Scanner;

/*
需求：
键盘录入字符串
分别统计并输出大写字母，小写字母，数字的个数
 */
public class StringTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numcount = 0;
        int bigcount = 0;
        int smacount = 0;
        char ch;

        for(int i = 0; i <s.length(); i ++) {
            ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                numcount ++;
            } else if(ch >= 'A' && ch <= 'Z') {
                bigcount ++;
            } else if(ch >= 'a' && ch <= 'z') {
                smacount ++;
            } else {
                System.out.println("检测到非法字符");
                break;
            }
        }
        System.out.println("numcount=" + numcount);
        System.out.println("bigcount=" + bigcount);
        System.out.println("smacount=" + smacount);
    }
}
