package IDEA_code;

import java.util.ArrayList;
import java.util.Scanner;

public class deleteStudent {
    public deleteStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要删除学生的学号");
        String s = sc.nextLine();
        for(int i = 0; i < arr.size(); i ++) {

            if(arr.get(i).getId().equals(s)) {
                arr.remove(i);
                break;
            }
        }
        System.out.println("删除成功");
    }
}
