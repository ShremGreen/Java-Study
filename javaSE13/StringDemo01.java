package API;
/*
String 和其他类型的转换
 */
public class StringDemo01 {
    public static void main(String[] args) {
        String s = "123456";//字符串常量池
        //String转化为基本数据类型   包装类.parseXxx(str);
        //int a = (int) s;//错误，强转需要子父类关系
        int i = Integer.parseInt(s);

        //基本类型包装类转化为String：通过String的重载方法
        int b = 123456;
        String st = String.valueOf(b);
        String str = b + "";//堆

        System.out.println(s == str);//前者是字符串常量池，后者是堆，地址不同
    }
}

