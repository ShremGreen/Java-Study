package JavaSE.InnerClass;

//要求控制台输出“HelloWorld”
interface In {
    void show();
}

class Out{
    //??????????补出Out类代码
    public static In method() {
        return new In() {
            public void show() {
                System.out.println("HelloWorld");
            }
        };
    }
}

public class Interview {
    public static void main(String[] args) {
        Out.method().show();
    }
}
