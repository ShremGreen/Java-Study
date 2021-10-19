package JavaSE.API;
/*
需求：
比较字符串是否对称。
 */

public class StringBufferTest02 {
    public static void main(String[] args) {
        String s1 = "lrccrl";
        String s2 = "javavaj";
        System.out.println(symmetry1(s1));
        System.out.println(symmetry1(s2));
        System.out.println(symmetry2(s1));
        System.out.println(symmetry2(s2));
    }
    //方法1
    public static boolean symmetry1(String str) {
        boolean b = true;
        char[] ch = str.toCharArray();
        for(int x = 0, y  = str.length() - 1; x < y; x++, y--) {
            if(ch[x] != ch[y]) {
                b =false;
            }
        }
        return b;
    }
    //方法2
    public static boolean symmetry2(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
    }
}
