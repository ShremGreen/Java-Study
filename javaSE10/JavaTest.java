package Thread;

import java.sql.SQLOutput;

public class JavaTest {
    public static void main(String[] args) {
        Test t = new Test();
        Method m1 = new Method(t);
        Method m2 = new Method(t);
        Method m3 = new Method(t);
    }
}

class Test {
    int[] arr = {1,2,3,4,5};
    public void show() {
        System.out.println(arr);
    }
}
class Method {
    public Method(Test test) {
        System.out.println(test.arr);
    }
}
