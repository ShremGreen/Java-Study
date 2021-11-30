package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Test
    public void test3() {
        
    }
}