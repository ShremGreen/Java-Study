package JavaSE.API;
/*
自动拆箱和自动装箱
将基本类型自动转化为包装类型
将包装类型自动转化为基本类型
 */
public class IntegerDemo03 {
    public static void main(String[] args) {
        Integer i = 100;
        i += 100;
        System.out.println("i:" + i);
    }
}
/*
反编译结果：
通过反编译后的代码
Integer i = Integer.value0f(100);
i = Integer.valueOf(i.intValue() + 100) ;
System.out.println((new StringBuilder("i:")).append(i).toString()) ;
 */
