package IDEA_code;

public class StringDemo1 {
    public static void main(String[] args) {
        char[] chs = {'a','b','c'};
        String s1 = new String(chs);
        String s2 = new String(chs);
        String s3 = "abc";
        String s4 = "abc";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s4));

    }
}
