package Collection;

import org.junit.Test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo2 {
    @Test
    public void test() {
        Comparator com = new Comparator() {
            public int compare(Object o1, Object o2) {
                if(o1 instanceof People && o2 instanceof People) {
                    People p1 = (People) o1;
                    People p2 = (People) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                } else throw new RuntimeException("输入类型不符！！！");
            }
        };
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new People("yzb", 21));
        treeSet.add(new People("pjs", 23));
        treeSet.add(new People("lrc", 22));

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class People {
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (age != people.age) return false;
        return name != null ? name.equals(people.name) : people.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}