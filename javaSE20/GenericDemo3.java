package Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
泛型在继承中的体现

 */
public class GenericDemo3 {
    @Test
    public void test1() {
        Object obj1 = new Object();
        String str1 = new String("lrc&Java");
        obj1 = str1;
        //str = obj;//子父类关系

        Object[] obj2 = null;
        String[] str2 = null;
        obj2 = str2;

        List<Object> obj3 = new ArrayList<Object>();
        List<String> str3 = new ArrayList<String>();
        //obj3 = str3;//编译不通过
    }

    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);

        List list3 = new ArrayList();
        list3.add(123);
        list3.add(12);
        list3.add(1);

        //添加数据
        //list.add(1);//使用通配符后不能继续添加数据
        list3.add(null);

        //获取数据
        Object o = list.get(1);//带入Object类
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
