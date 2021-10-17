package JavaSE.API;

/*
String类的获职功能
        int length() :获取字符串的长度。
        charAt (int index) :获取指定索引位置的字符
        int indexOf (int ch) : 返回指定字符在此字符串中第一次出现处的索引。
                               为什么这里是int类型，而不是char类型?
                               原因是: 'a和97其实都可以代表'a'
        int indexof (String str) :返回指定字符串在此字符串中第一次出现处的索引。
        int indexOf (int ch,int fromIndex) :返回指定字符在此字符串中从指定位置后第-次出现处的索引。
        int indexOf (String str,int fromIndex) :返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
        String substring(int start) :从指定位置开始截取字符串，默认到末尾。
        String substring(int start, int end) :从指定位置开始到指定位置结束截取字符串。

 */
public class StringDemo01 {
    public static void main(String[] args) {
        String s = "lirongchun";
        System.out.println(s.length());//10

        System.out.println(s.charAt(6));//c

        System.out.println(s.indexOf("li"));//0
        System.out.println(s.indexOf('l'));//0
        System.out.println(s.indexOf("un",5));//8
        System.out.println(s.indexOf('c',11));//-1
        System.out.println(s.indexOf('s',1));//-1

        System.out.println(s.substring(5));//gchun
        System.out.println(s.substring(5,10));//gchun

    }
}
