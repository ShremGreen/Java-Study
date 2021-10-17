package JavaSE.API;
/*
* 需求
* 1.反向输出录入的字符串
* 2.统计已有字符串中"java"出现的次数
*/

import java.util.Scanner;

public class StringTest02 {
    public static void main(String[] args) {
        System.out.println(reverse());
        String s1 = "wecyujavasnjahabifojerjavamdksojavajjjava";
        String s2 = "java";
        System.out.println("出现次数：" + num(s1,s2));
    }

    //定义reverse方法
    public static String reverse() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = "";


        char[] ch1 = s1.toCharArray();
        for(int i = ch1.length - 1; i >= 0; i --) {
            s2 += ch1[i];
        }
        return s2;
    }

    //定义统计字符串出现次数方法
    public static int num(String s1, String s2) {
        int count = 0;
        int index;
        while((index = s1.indexOf(s2)) != -1) {//这里indexOf()方法判断的是第一次出现，返回值是索引值
            count ++;
            s1 = s1.substring(index + s2.length());//从第一次出现的位置进行截取，再进入下一次循环
        }
        return count;
    }
}
