package JavaSE.API;

/*
字符串反转
 */
public class StringBufferTest01 {
    public static void main(String[] args) {
        long intime;
        long outtime;

        intime = System.currentTimeMillis();
        reverse1();
        outtime = System.currentTimeMillis();
        System.out.println(outtime - intime + "ms");//25ms

        intime = System.currentTimeMillis();
        reverse2();
        outtime = System.currentTimeMillis();
        System.out.println(outtime - intime + "ms");//0ms

        intime = System.currentTimeMillis();
        reverse3();
        outtime = System.currentTimeMillis();
        System.out.println(outtime - intime + "ms");//0ms
    }

    public static void reverse1() {
        //方法1
        String s1 = "lrcjava";
        char[] arr = s1.toCharArray();
        String s2 = "";
        for(int i = arr.length - 1; i >= 0; i --) {
            s2 += arr[i];
        }
        System.out.println(s2);
    }

    public static void reverse2() {
        //方法2
        String s1 = "lrcjava";
        StringBuffer sb = new StringBuffer(s1);
        sb.reverse();
        sb.toString();
        System.out.println(sb);
    }

    public static void reverse3() {
        String s1 = "lrcjava";
        System.out.println(new StringBuffer(s1).reverse().toString());
    }
}
