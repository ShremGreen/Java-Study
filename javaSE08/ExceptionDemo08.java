package JavaSE.Exception;
/*
自定义异常
步骤：
1.自定义异常须继承自某现有异常
2.需要有自己的序列号标识serialVersionUID
3.需要构造方法
 */
public class ExceptionDemo08 {
    public static void main(String[] args) {

    }
}

class MyException extends RuntimeException{
    static final long serialVersionUID = -7034897190745766939L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
