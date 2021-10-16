package JavaSE.InnerClass;

class Student1 {
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Alt+Insert    方法重写
    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class toStringDemo {
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.setName("李荣春");
        s.setAge(22);
        System.out.println(s);//JavaSE.InnerClass.Student1@49e4cb85
        System.out.println(s.toString());//结果同上
    }
}

/*    public void println(Object x) {
        String s = String.valueOf(x);
        synchronized (this) {
            print(s);
            newLine();
        }
    }

    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
*/
