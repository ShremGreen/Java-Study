package Collection;

/*
Collections

*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(856);
        list.add(00);
        list.add(215);
        list.add(36);
        list.add(-8);
        System.out.println(list);

        //Collections.reverse(list);
        //Collections.shuffle(list);
        //Collections.sort(list);
        System.out.println(list);


    }
}
