package Collection;

import org.junit.Test;

import java.util.*;

public class MapDemo {
    @Test
    public void test1() {
        Map map = new HashMap();
        map.put(12,"lrc");
        map.put(null,null);
        Map map1 = new TreeMap();
        map1.put(null,123);
        //Map map2 = new Hashtable();
        //map2.put(null,123);//NullPointerException
    }

    @Test
    //Map接口put()方法
    public void test2() {
        Map map = new HashMap();
        map.put("AA",123);
        map.put("AA",456);//替换功能
        map.put("BB",123);
        map.put("CC",666);
        System.out.println(map);
    }

    /*
    Map的遍历功能
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA",123);
        map.put("AA",456);//替换功能
        map.put("BB",123);
        map.put("CC",666);

        //遍历所有key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历所有value
        Collection values = map.values();
        for(Object obj : values) {
            System.out.println(obj);
        }

        //遍历所有key-value
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();

        while(iterator1.hasNext()) {
            //System.out.println(iterator1.next());
            //Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
}
