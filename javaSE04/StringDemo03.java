package JavaSE.API;
/*
String类的其他功能:
        替换功能:
        String replace(char old, char new)
        String replace(String old,String new)
        去除字符串两空格:
        String trim()
        按字典顺序比较两个字符串:
        int compareTo(String str)
        int compareToIgnoreCase(String stx)

*/
public class StringDemo03 {
    public static void main(String[] args) {
        String s1 = "helloworld";

        System.out.println(s1.replace("lo","zzz"));
        System.out.println(s1.replace('l','z'));//hezzoworzd    所有的都换

        String s2 = " Hello World ";
        System.out.println(s2.trim());

        String s3 = "dsfsd";
        String s4 = "dsnfdk";
        String s5 = "Dsfsd";
        String s6 = "snfjk";
        System.out.println(s3.compareTo(s4));//-8
        System.out.println(s3.compareTo(s5));//32   ascii码大小写差32
        System.out.println(s3.compareTo(s6));//-15
    }
}
