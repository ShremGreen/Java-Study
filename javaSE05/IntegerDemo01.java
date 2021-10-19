package JavaSE.API;
/*
包装类：
工具类。为了对基本类型进行更方便的操作，Java针对每一种基本类型都有对应的类。

Integer 构造方法
public Integer(int value)
public Integer(String str)

int String转化
记       Integer.toString(int i)
String int转化
记       Integer.parseInt(String s)
 */
public class IntegerDemo01 {
    public static void main(String[] args) {
        int i = 100;
        Integer in1 = new Integer(i);
        System.out.println(in1);

        String str = "100";
        Integer in2 = new Integer(str);
        System.out.println(in2);

        //int转为String
        //1
        String s1 = "" + i;
        //2
        String s2 = String.valueOf(i);
        //3
        Integer in = new Integer(i);
        String s3 = in.toString();
        //4
        String s4 = Integer.toString(i);

        //String转为int
        int a = Integer.parseInt(str);
    }
}
