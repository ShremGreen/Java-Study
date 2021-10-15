import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public StudentSystem(ArrayList<Student> arr) {
        while (true) {
            System.out.println("........学生系统........");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");

            System.out.println("请输入:");
            //键盘录入2
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            switch (s) {
                case "1":
                    System.out.println("添加学生");
                    new addStudent(arr);
                    break;
                case "2":
                    System.out.println("删除学生");
                    break;
                case "3":
                    System.out.println("修改学生");
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //break;
                    System.exit(0);//JVM退出//或者用标志位跳出多层循环
                default:
                    System.out.println("输入有误！！！");
                    break;
            }
        }
    }
}