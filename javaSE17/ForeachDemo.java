package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
foreach()   增强版for循环
 */
public class ForeachDemo {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add("Java");
        coll.add(false);
        coll.addAll(Arrays.asList(new Integer[] {1,2,3}));
        coll.add(new String("C3"));
        System.out.println(coll);

        //格式    for(类型 接收变量 : 集合) {...}
        for(Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    //比较for和增强for
    public void test2() {
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "123";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);//5个null
            //原因：新建了一个变量，并没有给集合赋值
        }
    }
}
