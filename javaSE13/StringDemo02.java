package API;

public class StringDemo02 {
    public static void main(String[] args) {
        String s1 = "lrc";
        String s2 = "123";

        String s = "lrc123";
        String s3 = "lrc" + "123";
        String s4 = s1 + "123";      //在堆中操作
        String s5 = "lrc" + s2;      //在堆中操作
        System.out.println(s == s3); //true
        System.out.println(s == s4); //false
        System.out.println(s == s5); //false
        System.out.println(s4 == s5);//false

        //intern()  返回常量池中的字符串
        String s6 = s5.intern();//由于常量池中已有"lrc123",将其地址值直接连接给s6
        String s7 = s5;
        System.out.println(s == s6); //true
        System.out.println(s == s7); //false
        System.out.println(s7 == s5);//true
    }
}
