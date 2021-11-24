package Collection;

import org.junit.Test;
import java.util.Iterator;
import java.util.TreeSet;

/*
TreeSet
按照添加对象的指定顺序进行排序
 */
public class TreeSetDemo {
    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();
        treeSet.add("lrc");
        treeSet.add(123);
        //java.lang.ClassCastException
        //at java.base/java.lang.Integer.compareTo(Integer.java:59)
        //不能存放不同数据类型
    }

    @Test
    public void test2() {
        TreeSet treeSet1 = new TreeSet();
        treeSet1.add(95);
        treeSet1.add(-32);
        treeSet1.add(64);
        treeSet1.add(0);
        System.out.println(treeSet1);//[-32, 0, 64, 95]
    }

    @Test
    public void test3() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new User1("lrc",22));
        treeSet.add(new User1("yzb",21));
        treeSet.add(new User1("pjs",23));
        treeSet.add(new User1("lrc",75));//此时只会显示一个lrc
        System.out.println(treeSet);//java.lang.ClassCastException: class Collection.User1 cannot be cast to class java.lang.Comparable
        //因为没有自定义比较器Comparable

        //iterator迭代器   遍历集合
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //compareTo方法重写后
        //[User1{name='lrc', age=22}, User1{name='lrc', age=75}, User1{name='pjs', age=23}, User1{name='yzb', age=21}]
    }
}

class User1 implements Comparable{
    private String name;
    private int age;

    public User1() {
    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    //compareTo
    public int compareTo(Object o) {
        if(o instanceof User1) {
            User1 user = (User1) o;
            int r = this.name.compareTo(user.getName());
            if(r == 0) {
                return Integer.compare(this.age,user.getAge());
            } else return r;
        } else {
            throw new RuntimeException("数据类型不匹配！！！");
        }
    }
}
