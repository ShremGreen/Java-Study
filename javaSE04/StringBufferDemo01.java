package JavaSE.API;
/*
线程安全：
安全       同步      数据安全
不安全     不同步     效率高

StringBuffer:               线程安全的可变字符串
StringBuffer相对于String     不会浪费太多空间和资源

StringBuffer的构造方法:
    public StringBuffer () :无参构造方法
    public StringBuffer (int capacity) :指定容量的字符串缓冲中区对象
    public StringBuffer (String str) :指定字符串内容的字符串缓冲区对象
StringBuffer的方法:
    public int capacity() :返回当前容量。理论值
    public int length() :返回长度(字符数)。实际值

 */
public class StringBufferDemo01 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();//空的字符串缓冲区
        System.out.println(sb1.capacity());//16 默认容量为16
        System.out.println(sb1.length());//0
        System.out.println(sb1);//说明toStirng()被重写

        StringBuffer sb2 = new StringBuffer(50);//容量为50的字符串缓冲区
        System.out.println(sb2.capacity());//50
        System.out.println(sb2.length());//0
        System.out.println(sb2);

        StringBuffer sb3 = new StringBuffer("li rongchun");//内容为字符串的字符串缓冲区
        System.out.println(sb3.capacity());//27 默认容量+实际长度
        System.out.println(sb3.length());//11
        System.out.println(sb3);
        /*
        源码：
            public StringBuffer(String str) {
                super(str.length() + 16);
                append(str);
            }
         */
    }
}
