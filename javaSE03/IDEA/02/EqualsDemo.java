package JavaSE.InnerClass;

class Student2 {
    private String name;
    private int age;

    public Student2() {
    }

    public Student2(String name, int age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student2 student2 = (Student2) o;

        if (age != student2.age) return false;
        return name != null ? name.equals(student2.name) : student2.name == null;
    }
}

public class EqualsDemo {
    public static void main(String[] args) {
        Student2 s1 = new Student2();
        Student2 s2 = new Student2();

        System.out.println(s1.equals(s2));//false,因为比较的是地址值
        //重写equals方法后结果为true
    }
}
