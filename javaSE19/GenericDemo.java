package Collection;

import org.junit.Test;

import java.util.*;

public class GenericDemo {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(33);
        list.add("LRC");//此时不正常

        for(Object obj : list) {
            int score = (int) obj;//ClassCastException，此时不正常
            System.out.println(score);
        }
    }

    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList();//定义泛型约束
        list.add(1);
        list.add(2);
        list.add(33);
        //list.add("LRC");//在编译时就报错

        //遍历操作1
        for(Integer integer : list) {
            int stuScore = integer;
            System.out.println(stuScore);
        }

        //遍历操作2
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test//HashMap中泛型的嵌套    遍历
    public void test3() {
        Map<String,Integer> map = new HashMap();

        map.put("Aa",123);
        map.put("Bb",465);
        map.put("Cc",789);
        //map.put(132,"lrc");

        //Map集合遍历
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while(iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "\t" + value);
        }
    }
}