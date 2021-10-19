package JavaSE.API;
/*
int类型的进制转换
Integer.toBinaryString(i)
Integer.toOctalString(i)
Integer.toHexString(i)

十进制到其他进制（2-36）
Integer.toString(i,radix)
其他进制到十进制
Integer.parseInt(s,radix)
 */
public class IntegerDemo02 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toOctalString(100));
        System.out.println(Integer.toHexString(100));

        //任意转换
        //10到其他
        System.out.println(Integer.toString(100,2));//1100100
        System.out.println(Integer.toString(100,36));//2s
        //其他到10
        System.out.println(Integer.parseInt("100",2));//4

    }
}
