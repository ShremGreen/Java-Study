package Collection.test_Generic;

import java.util.*;

public class EmployTest {
    public static void main(String[] args) {
        Set<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        Employee employee1 = new Employee("LRC",22,new MyDate(1999,2,16));
        Employee employee2 = new Employee("YZB",21,new MyDate(2000,9,2));
        Employee employee3 = new Employee("RLJ",23,new MyDate(1998,1,6));
        Employee employee4 = new Employee("PJS",24,new MyDate(1997,4,11));

        //向Set添加元素
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);

        //遍历集合iterator
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
