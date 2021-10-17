package JavaSE.API;
/*
String的转换功能:
        byte[] getBytes () :把字符串转换为字节数组。
        char[] toCharArray() : 把字符串转换为字符数组。
        static String valueOf (char[] chs) :把字符数组转成字符串。
        static String valueOf (int i) :把int类型的数据转成字符串。
            注意: String类的value0f方法可以把任意类型的数据转成字符串。
        String toLowerCase () :把字符串转成小写。
        String toUpperCase () :把字符串转成大写。
        String concat (String str) :把字符串拼接。
*/
public class StringDemo02 {
    public static void main(String[] args) {
        String s = "Hello123World";

        byte[] b = s.getBytes();
        char[] c = s.toCharArray();
        for(int i = 0; i < b.length; i ++) {
            System.out.println(b[i]);
        }
        for(int i = 0; i < b.length; i ++) {
            System.out.println(c[i]);
        }

        int i = 100;
        System.out.println(String.valueOf(i));
        System.out.println(new String(b));
        System.out.println(String.valueOf(c));
        System.out.println(new String(c));
    }
}
