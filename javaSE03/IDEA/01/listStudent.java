package IDEA_code;

import java.util.ArrayList;

public class listStudent {
    public listStudent(ArrayList<Student> arr) {
        System.out.println("姓名：\t\t年龄：\tID：\t");
        for(int i = 0; i <= arr.size() - 1; i ++) {
            Student s = arr.get(i);
            System.out.println(s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getId());
        }
    }
}
