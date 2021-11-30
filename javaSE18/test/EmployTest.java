package Collection.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
创建五个Employee对象，按照比较器自定义规则排序
1.根据名字
2.根据出生日期
 */
public class EmployTest {
    public static void main(String[] args) {
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate birthday1 = e1.getBirthday();
                    MyDate birthday2 = e2.getBirthday();

                    int Y = birthday1.getYear() - birthday2.getYear();
                    if(Y != 0) {
                        return Y;
                    } else {
                        int M = birthday1.getMonth() - birthday2.getMonth();
                        if(M != 0) {
                            return M;
                        } else {
                            int D = birthday1.getDay() - birthday2.getDay();
                            if(D != 0) {
                                return D;
                            }
                        }
                    }
                }
                return 0;
            }
        });

        Employee employee1 = new Employee("LRC",22,new MyDate(1999,2,16));
        Employee employee2 = new Employee("YZB",21,new MyDate(2000,9,2));
        Employee employee3 = new Employee("RLJ",23,new MyDate(1998,1,6));
        Employee employee4 = new Employee("PJS",24,new MyDate(1997,4,11));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
