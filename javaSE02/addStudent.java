import java.util.ArrayList;
import java.util.Scanner;

public class addStudent {
    public addStudent(ArrayList<Student> arr) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入学生姓名：");
            String name = sc.nextLine();
            s.setName(name);

            System.out.println("请输入学生年龄：");
            int age = sc.nextInt();
            s.setAge(age);

            System.out.println("请输入学生id：");
            String ID = sc.nextLine();
            s.setId(ID);

            arr.add(s);
            System.out.println("继续添加学生信息？   （是/否）");
            String x = sc.nextLine();
            if(x == "否") {
                break;
            }
        }
        System.out.println("学生信息录入完成");
    }
}
