package JavaSE.API;

public class Test01 {
    public static void main(String[] args) {
        Father01 f = new Son01();
        f.show();
    }
}
class Father01 {
    public void show() {
        System.out.println("father");
    }
}
class Son01 extends Father01 {
    public void show() {
        System.out.println("son");
    }
}