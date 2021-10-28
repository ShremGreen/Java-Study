package Project.teamview;

import java.util.Scanner;

/*
TSUtility类  实现键盘录入和判断
需求：
1.读取键盘录入数据      readKeyBoard                private
2.判断Y/N功能           readConfirmSelection      public
3.选择1-4操作            readMenuSelection        public
4.提示并等待直到按回车       readReturn              public
5.选择序号功能               readInt               public
 */
public class TSUtility {
    private static Scanner sc = new Scanner(System.in);

    //选择序号功能
    public static int readInt() {
        int i;
        for(;;) {
            String s = readKeyBoard(2, false);
            try {
                i = Integer.parseInt(s);
                break;
            } catch(NumberFormatException e) {
                System.out.println("输入错误！（int）");
            }
        }
        return i;
    }

    //选择1-4操作功能
    public static char readMenuSelection() {
        char c;
        for(;;) {
            String s = readKeyBoard(1, false);
            c = s.charAt(0);
            if(c == '1' || c == '2' || c == '3' || c == '4') {
                break;
            } else System.out.println("输入错误！(1/2/3/4)");
        }
        return c;
    }

    //判断Y/N功能
    public static char readConfirmSelection() {
        char c;
        for(;;) {
            String s = readKeyBoard(1, false).toUpperCase();
            c = s.charAt(0);
            if(c == 'Y' || c == 'N') {
                break;
            } else System.out.println("输入错误！（Y/N）");
        }
        return c;
    }

    //回车键继续方法
    public static void readReturn() {
        System.out.println("按回车键继续...");
        readKeyBoard(1, true);
    }

    //读取键盘录入数据并判断
    private static String readKeyBoard(int limit, Boolean judge) {
        String line = "";
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            //判断是否录入回车
            if(line.length() == 0) {
                if(judge) return line;
                else continue;
            }
            //判断录入字符长度
            if(line.length() < 1 || line.length() > limit) {
                System.out.println("键盘录入长度错误！重新输入：");
                continue;//跳进下一个循环
            }
            break;
        }
        return line;//返回键盘录入字符串
    }
}
