package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Demo01 {
    @Test
    public void test1() {
        //向上转型  Collection中没有直接可用方法，需要多态
        Collection coll = new ArrayList();

        //add(Object e)
        coll.add("lrc");
        coll.add("123");
        coll.add(456);
        coll.add(new Date());

        //size()
        System.out.println(coll.size());//4

        //addAll()
        Collection coll1 = new ArrayList();
        coll1.add("java");
        coll1.add(1062702315);
        coll.addAll(coll1);
        System.out.println(coll);//[lrc, 123, 456, Wed Nov 17 14:37:29 CST 2021, java, 1062702315]

        //clear()
        coll1.clear();
        System.out.println(coll1);//[]

        //isEmpty()
        System.out.println(coll1.isEmpty());//true
        System.out.println(coll.isEmpty());//false
        Collection coll2 = new ArrayList();
        coll2.add(null);
        System.out.println(coll2.isEmpty());//false

    }
}
