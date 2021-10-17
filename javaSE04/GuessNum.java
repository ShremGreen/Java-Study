package JavaSE.API;

import java.util.Scanner;

public class GuessNum {
    private GuessNum() {
    }

    public static void guess() {
        int x = (int) (Math.random()*100+1);

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字");
            int y = sc.nextInt();
            if(y < x) {
                System.out.println("太小了");
            } else if(y > x) {
                System.out.println("太大了");
            } else {
                System.out.println("您猜对了");
                break;
            }
        }
    }
}
