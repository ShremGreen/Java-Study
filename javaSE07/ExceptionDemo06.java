package JavaSE.API;

public class ExceptionDemo06 {
    public static void main(String[] args) {
        new Father().method();//这是父类method

        Father f = new Son();
        f.method();//这是子类method

        ExceptionDemo06 e = new ExceptionDemo06();
        e.show(new Son());//这是子类method
    }
    public void show(Father f) {
        try {
            f.method();
        } catch(ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
class Father {
    public void method() throws RuntimeException{
        System.out.println("这是父类method");
    }
}
class Son extends Father {
    @Override
    public void method() throws RuntimeException {
        System.out.println("这是子类method");
    }
}
