package IDEA_code;

public class StringDemo {
    public static void main(String[] args) {
        char[] chs = {'a','b','c'};//堆中新开辟一个字符数组
        String s1 = new String(chs);//堆中开辟一个字符串
        String s2 = new String(chs);//堆中再开辟一个字符串
        System.out.println(s1 == s2);//比较两个字符串的地址值
        System.out.println(s1);

        String s3 = "efg";
        String s4 = "efg";//两个字符串地址值相同
        String s5 = "hig";
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
    }
}
