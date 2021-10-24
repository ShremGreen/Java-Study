package JavaSE.Exception;

import java.util.Scanner;

/*
手动抛出异常
 */
public class ExceptionDemo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生Id：");
        String s = sc.nextLine();
        Student stu = new Student();
        try {
            stu.check(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        System.out.println(stu.getId());
    }
}
class Student {
    private String Id;
    public void check(String Id) throws Exception{//处理异常
        if(Integer.parseInt(Id) > 0) {
            this.Id = Id;
        } else {
            //System.out.println("数据输入错误");//以前都是这种，但这应该属于一种错误，需要手动抛出异常
            //throw new RuntimeException("数据输入错误");//这是运行时异常，只是生成，而没有解决
            //throw new Exception("数据输入错误");//生成异常
            throw new MyException("数据输入错误");
        }
    }

    public String getId() {
        return Id;
    }
}