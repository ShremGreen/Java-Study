package Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {
    @Test
    public void test1() {
        List<? extends Person> list1 = null;//通配符代表Person及以下
        List<? super Person> list2 = null;  //通配符代表Person及以上

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        Person p = list1.get(0);

        //编译不通过
        Object obj = list2.get(0);
        //Person obj = list2.get(0);
}

class Person {}

class Student extends Person {}
}