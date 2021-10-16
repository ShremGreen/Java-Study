package IDEA_code;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "17040410032";
        String s2 = "951esz753";

        for (int i = 3; i >= 1; i--) {
            Scanner sc = new Scanner(System.in);
            System.out.println("用户名：");
            String s3 = sc.nextLine();
            System.out.println("密码");
            String s4 = sc.nextLine();

            if (s1.equals(s3) && s2.equals(s4)) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("登录失败" + '\n' + "还有" + (i-1) + "次机会");
            }
        }
    }
}
