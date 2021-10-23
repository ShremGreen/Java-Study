package JavaSE.API;
/*
try-catch-finally
finally 必须被执行，而且顺序优先于返回值
 */
public class ExceptionDemo03 {
    public static void main(String[] args) {
        System.out.println(finallyTest1());
        System.out.println(finallyTest2());
    }
    public static int finallyTest1() {//顺序：先异常跳入catch，进行printStackTrace，再finally,最后return 2
        try {
            int x = 0;
            int y = 3;
            System.out.println(y/x);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("必须被执行的finally");
        }
    }
    public static int finallyTest2() {//顺序：先异常跳入catch，在1之前进行finally,最后return 1
        try {
            int x = 0;
            int y = 3;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("必须被执行的finally");
        }
    }
}
