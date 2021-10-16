package IDEA_code;

public class InterDemo {
    private int num = 10;

    public class Inter {
        public void show() {
            System.out.println(num);
        }
    }//可以通过普通方式直接调用；格式：InterDemo.Inter ii = new InterDemo().new Inter();

    private class Inter1 {
        public void show1() {
            System.out.println(num);
        }
    }//因为是私有方法，不能直接创建对象，

    public void method() {
        Inter1 in = new Inter1();
        in.show1();
    }
}
