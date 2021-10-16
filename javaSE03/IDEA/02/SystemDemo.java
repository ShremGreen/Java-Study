package JavaSE.InnerClass;

public class SystemDemo {
    public static void main(String[] args) {
/*        System.out.println("开始");
        System.exit(0);
        System.out.println("结束");*/

        System.out.println(System.currentTimeMillis());
        long T_in = System.currentTimeMillis();
        System.out.println(T_in);
        int sum = 0;
        for(int i = 0; i < 100000; i ++) {
            sum += i;
        }
        long T_out = System.currentTimeMillis();
        System.out.println(T_out);
        long time = T_out - T_in;
        System.out.println(time + "ms");
    }
}
