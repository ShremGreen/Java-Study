package API;

import java.io.UnsupportedEncodingException;

public class StringDemo04 {
    public static void main(String[] args) {
        String str = "中";
        try {
            System.out.println(str.getBytes("ISO8859-1").length);// -128~127
            System.out.println(str.getBytes("GBK").length);
            System.out.println(str.getBytes("UTF-8").length);
            System.out.println(new String(str.getBytes("ISO8859-1"), "ISO8859-1"));// 乱码，表示不了中文
            System.out.println(new String(str.getBytes("GBK"), "GBK"));
            System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
