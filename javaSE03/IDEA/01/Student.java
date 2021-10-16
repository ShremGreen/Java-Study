package IDEA_code;

//快捷键：Alt+Insert

public class Student {

    private String name;
    private String age;
    private String ID;

    public Student() {
    }
    public Student(String name, String age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }
}
