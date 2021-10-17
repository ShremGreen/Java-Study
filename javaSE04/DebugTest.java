package JavaSE.API;

import java.util.Scanner;

public class DebugTest {
    public static void main(String[] args) {
        String n = "admin";
        String p = "123456";

        for(int i = 2; i > 0; i --) {
            Scanner sc = new Scanner(System.in);
            System.out.println("用户名：");
            String username = sc.nextLine();
            System.out.println("密码：");
            String password = sc.nextLine();

            if(username.equals(n) && password.equals(p)) {
                System.out.println("正在跳转猜数字小游戏......");
                GuessNum.guess();
                break;
            } else {
                System.out.println("用户名或密码错误\n" + "你还有" + (i) + "次机会");
            }
        }
    }
}
