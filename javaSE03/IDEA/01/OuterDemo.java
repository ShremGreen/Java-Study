package IDEA_code;

public class OuterDemo {
    public static void main(String[] args) {
        InterDemo.Inter ii = new InterDemo().new Inter();
        ii.show();

        InterDemo i = new InterDemo();
        i.method();
    }
}
