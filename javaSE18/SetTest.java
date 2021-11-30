package Collection;

import org.junit.Test;
import java.util.HashSet;
/*
1   输出带有两个元素的数组
2   输出两个，并未移除，因为重写的hashCode方法是与该对象的属性相关的，而属性已经改变，那么在根据哈希码寻找地址时，并非原本地址
3   此处地址与上一步的地址相同，此时这个地址没有元素，所以根据哈希值判断可以添加
4   此时没有name为AA的对象，因此计算出的哈希码也是可以的
 */
public class SetTest {
    @Test
    public void test() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(p1.hashCode());//33111
        System.out.println(set);//[Person{ID=1002, name='BB'}, Person{ID=1001, name='AA'}]

        //为name重新赋值，并移除该对象
        p1.name = "CC";
        System.out.println(p1.hashCode());//33175
        set.remove(p1);
        System.out.println(set);//[Person{ID=1002, name='BB'}, Person{ID=1001, name='CC'}]

        //添加对象并判断
        set.add(new Person(1001,"CC"));
        System.out.println(set);//[Person{ID=1002, name='BB'}, Person{ID=1001, name='CC'}, Person{ID=1001, name='CC'}]
        set.add(new Person(1001,"AA"));
        System.out.println(set);//[Person{ID=1002, name='BB'}, Person{ID=1001, name='CC'}, Person{ID=1001, name='CC'}, Person{ID=1001, name='AA'}]
    }
}
