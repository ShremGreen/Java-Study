package JavaSE.API;

import java.util.Scanner;

/*
正则表达式
需求：判断键盘录入QQ是否满足要求
    5-15位的数字串，0不能是开头
 */
public class RegexDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(checkQQ1(s));
        System.out.println(checkQQ2(s));
    }

    public static boolean checkQQ1(String s) {
        boolean b = false;
        if(s.length() > 4 && s.length() < 16) {
            if(!s.startsWith("0")){
                char[] arr = s.toCharArray();
                for(int i = 0; i < s.length(); i ++) {
                    if(!Character.isDigit(arr[i])) {
                        break;
                    }
                }
                b = true;
            }
        }
        return b;
    }

    public static boolean checkQQ2(String s) {
        String regex = "[1-9][0-9]{4,14}";
        return s.matches(regex);
    }
}
