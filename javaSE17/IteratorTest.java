package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*
Collection类中Iterator，即迭代器

Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。
Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象。
Iterator 仅用于遍历集合，Iterator 本身并不提供承装对象的能力。如果需要创建Iterator对象，则必须有一个被迭代的集合。
集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 */
public class IteratorTest {
    @Test
    //创建并实现迭代器遍历
    public void test1() {
        //Collection接口的实现要通过多态，因为它没有任何可以直接实现的方式
        Collection coll = new ArrayList();//多态创建一个集合对象
        coll.add("Java");
        coll.add(false);
        coll.addAll(Arrays.asList(new Integer[] {1,2,3}));
        coll.add(new String("C3"));
        System.out.println(coll);

        //iterator  是Iterator接口的唯一方法，Collection接口继承自Iterator接口
        Iterator iterator = coll.iterator();//iterator()返回迭代器对象
        //遍历方法一   不推荐
        for(int i = 0; i < coll.size(); i ++) {
            System.out.println(iterator.next());//next()方法从0开始读取，自动累加
        }

        //遍历方法二
        while(iterator.hasNext()) {//有元素则返回boolean值true，
            System.out.println(iterator.next());
        }
    }

    @Test
    //remove()  区分于集合中的remove()
    public void test2() {
        Collection coll = new ArrayList();
        coll.add("Java");
        coll.add(false);
        coll.addAll(Arrays.asList(new Integer[] {1,2,3}));
        coll.add(new String("C3"));
        System.out.println(coll);

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if(obj.equals(false)) {
                iterator.remove();
            }
        }

        //再次遍历会没有显示，原因：此时指针已经在集合末尾
        /*while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}