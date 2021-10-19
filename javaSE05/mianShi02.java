package JavaSE.API;
/*
通过查看源码，针对-128-127之间的数据，存在一个数据缓冲池，
如果数据是该范围内的，每次并不创建新的空间
 */
public class mianShi02 {
    public static void main(String[] args) {
        Integer i1 = new Integer(128);
        Integer i2 = new Integer(128);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i3 = new Integer(127);
        Integer i4 = new Integer(127);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));

        Integer i7 = 127;
        Integer i8 = 127;
        System.out.println(i7 == i8);
        System.out.println(i7.equals(i8));

        Integer.valueOf(i7);//查看源码
    }
}
