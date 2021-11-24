package Collection;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionDemo02 {
    @Test
    public void test1() {
        //contains()    在判断自定义类时，需要用到equals()方法
        Collection coll = new ArrayList();
        coll.add("lrc");
        coll.add(true);
        System.out.println(coll.contains(true));//true
        System.out.println(coll.contains(0));//false

        coll.add(new String("Java"));
        System.out.println(coll.contains(new String("Java")));//true

        coll.add(new Dog("AA",6));
        System.out.println(coll.contains(new Dog("AA",6)));//因为没有重写equals方法

        //comtainsAll(Collection coll)  判断是否全部元素都属于集合
        Collection coll1 = Arrays.asList(true,"lrc");
        System.out.println(coll.containsAll(coll1));//true

        //remove()  返回值boolean
        System.out.println(coll.remove("123"));//false
        System.out.println(coll.remove("lrc"));//true
        System.out.println(coll);//[true, Java, Dog{name='AA', age=6}]

        //removeAll(Collection coll)   差集，移除两集合交集的元素
        coll.removeAll(coll1);
        System.out.println(coll);//[Java, Dog{name='AA', age=6}]

        /*//retainAll(Collection coll)    并集
        coll.retainAll(coll1);
        System.out.println(coll);//[]*/

        //equals()  判断两集合是否相等
        Collection coll2 = Arrays.asList(new Dog("AA",6),"Java");
        System.out.println(coll.equals(coll2));//false  说明判断顺序

        //hashcode()    返回hash码
        System.out.println(coll.hashCode());//486533843

        //toArray() 将集合内容转化为Object类型数组
        Object[] obj = coll.toArray();
        for(int i = 0; i < obj.length; i ++) {
            System.out.print(obj[i] + "\t\n");
        }

        //Arrays类中asList() 数组转为集合
        List<String> strings = Arrays.asList(new String[]{"aA", "bB"});
        System.out.println(strings);//[aA, bB]
        List ints = Arrays.asList(new int[]{1, 2, 3, 4});//int[] arr = new int[]{1,2,3,4};
        System.out.println(ints);//[[I@43a0cee9]
        System.out.println(ints.size());//1
        List integers = Arrays.asList(new Integer[]{2, 3, 4});//Integer[] arr = new Integer[]{2, 3, 4};
        System.out.println(integers.size());//3
    }
}
 class Dog {
     private String name;
     private int age;

     public Dog() {
     }

     public Dog(String name, int age) {
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
         return "Dog{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }

     @Override
     public boolean equals(Object o) {
         System.out.println("equals()...");
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Dog dog = (Dog) o;

         if (age != dog.age) return false;
         return name != null ? name.equals(dog.name) : dog.name == null;
     }

/*     @Override
     public int hashCode() {
         int result = name != null ? name.hashCode() : 0;
         result = 31 * result + age;
         return result;
     }*/
 }
