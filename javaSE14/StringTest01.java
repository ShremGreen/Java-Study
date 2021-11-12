package API;
/*
1.模拟一个trim方法，去除字符串两端的空格。
2.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
转为”abfedcg”
3.获取一个字符串在另一个字符串中出现的次数。
比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
4.获取两个字符串中最大相同子串。比如：
str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
提示：将短的那个串进行长度依次递减的子串与较长的串比较。
5.对字符串中字符进行自然顺序排序。
提示：
1）字符串变成字符数组。
2）对数组排序，选择，冒泡，Arrays.sort();
3）将排序后的数组变成字符串。
 */

class Methods {
    public void trim(String str) {
        System.out.println(str.trim());
    }
    public void reverse(String str) {
        StringBuilder sbd = new StringBuilder(str);
        System.out.println(sbd.reverse().toString());
    }
    public int numOut(String s, String S) {
        int count = 0;

        while(true) {
            if(S.indexOf(s) != -1) {
                count ++;
                S = S.substring(S.indexOf(s) + s.length());
            } else return count;
        }
    }
}

public class StringTest01 {
    public static void main(String[] args) {
        Methods methods = new Methods();
        String str = " asdafgahjk ";
        String s = "as";
        methods.trim(str);

        System.out.println(methods.numOut(s,str));
    }
}
