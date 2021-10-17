package JavaSE.API;
/*
String和StringBuffer是俩不一样的类，不能直接赋值，必须通过调用方法（构造或普通方法）转化
StringBuffer和String的转化

 */
public class StringBuffer03 {
    public static void main(String[] args) {
        //String化为StringBuffer
        String s = "helloworld";
        //方法1   构造方法
        StringBuffer sb1 = new StringBuffer(s);
        //方法2   append方法
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        //测试
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb1 == sb2);//false  new了两次

        //StringBuffer化为String
        StringBuffer sb = new StringBuffer("HELLOWORLD");
        //方法1   String构造方法
        String s1 = new String(sb);
        //方法2   toString方法
        String s2 = sb.toString();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);//false
    }
}
