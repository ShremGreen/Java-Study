package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
实现对List集合进行排除相同元素的操作
用到Set接口，因为Set具有不可重复性，自动过滤掉所有重复元素
 */
public class SetDemo1 {
    @Test
    public void remove() {
        List list = new ArrayList();
        list.add("chaun");
        list.add("JAva");
        list.add("chaun");
        list.add(new User1("lrc",22));
        list.add(new User1("lrc",22));
        //[[chaun, JAva, chaun, User1{name='lrc', age=22}, User1{name='lrc', age=22}]]
        //自定义对象重复，因为需要重写equals和hashCode方法
        List newList = method(list);

        for(Object object:newList) {
            System.out.println(newList);
        }
    }

    public List method(List list) {
        Set set = new HashSet();
        set.add(list);
        return new ArrayList(set);
    }
}
