package JavaSE.InnerClass;
/*
匿名内部类：
格式：
    new 类名/接口名() {
        重写方法；
        };
本质：是一个继承了该类/接口的子类对象
*/
public class Outer {
    public void method() {
        new Inter() {
            public void show() {
                System.out.println("匿名内部类");
            }
        };
    }
    //匿名内部类是一个对象，

    public void method1() {
        new Inter() {
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();
    }

    public void method2() {
        Inter i  = new Inter() {//这是多态
            public void show() {
                System.out.println("匿名内部类");
            }
        };
        i.show();
    }
}
