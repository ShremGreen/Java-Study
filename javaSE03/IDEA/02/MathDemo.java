package JavaSE.InnerClass;
/*      `public static int abs (int a)`	返回参数的绝对值
        `public static double ceil (double a)`	返回大于或等于参数的最小整数（double）
        `public static double floor (double a)`	返回小于或等于参数的最大整数（double）
        `public static int round (float a)`	按照四舍五入返回最接近参数的int
        `public static int max (int a,int b)`	返回两个int值中的较大值
        `public static int min (int a, int b)`	返回两个int值中的较小值
        `public static double pow (double a, double b)`	返回a的b次幂的值
        `public static double random ()`	返回值为double的正值，[0.0,1.0)
*/

public class MathDemo {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = -1;
        double d = 1.85;

        System.out.println(Math.abs(c));
        System.out.println(Math.ceil(d));
        System.out.println((int) Math.floor(d));
        System.out.println(Math.round(d));
        System.out.println(Math.max(a,b));
        System.out.println(Math.min(a,b));
        System.out.println(Math.pow(a,b));
        System.out.println((int) (Math.random()*100 + 1));
    }
}
