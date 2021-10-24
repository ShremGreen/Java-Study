package JavaSE.Exception;
/*
看程序写结果
*/
public class ExceptionTest01 {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        }finally {
            System.out.println("用A方法的final1y");
        }
    }
    static void methodB( ) {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("调用B方法的final1y");
        }
    }
    public static void main(String[] args) {
        try {
            methodA();//输出进入方法A、用A方法的final1y
        } catch (Exception e) {
            System.out.println(e.getMessage());//输出制造异常
        }
        methodB();
    }
}
