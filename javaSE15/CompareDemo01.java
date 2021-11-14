package API;
/*
Java中的对象，正常情况下，只能进行比较: ==或!=。不能使用>或<的
但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
如何实现?使用两个接口中的任何一个: Comparable或Comparator
 */
/*
Comparable接口：
像String、包装类等，内部都实现了Comparable接口，并重写了compareTo()方法

重写compareTo()规则：
1.比较结果由小到大排列  分别对应负数、零、正数
2.对于自定义类的排序，需要实现Comparable接口并重写compareTo()方法
 */

import org.junit.Test;

import java.util.Arrays;

public class CompareDemo01 {
    @Test
    public void test1() {
        String[] array = {"zdf","ADF","EGR","AAA","kex"};
        Arrays.sort(array);
        System.out.println(array.toString());//[Ljava.lang.String;@87f383f
        System.out.println(Arrays.toString(array));//[AAA, ADF, EGR, kex, zdf]
    }
}
