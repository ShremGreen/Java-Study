package Collection;

import org.junit.Test;
import java.util.*;

/*
ArrayList  LinkedList  Vector

void add(int index, Object ele)             //在index位置插入ele元素
boolean addAll(int index, Collection eles)  //从index位置开始将eles中的所有元素添加进来
Object get(int index)                       //获取指定index位置的元素
int indexOf(Object obj)                     //返回obj在集合中首次出现的位置
int lastIndexOf(Object obj)                 //返回obj在当前集合中末次出现的位置
Object remove(int index)                    //移除指定index位置的元素，并返回此元素
Object set(int index, Object ele)           //设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex)    //返回从fromIndex到toIndex位置的子集合
*/
public class ListDemo {
    @Test
    public void test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Java");
        arrayList.add(123);
        arrayList.add(new Integer[] {5,9,7});//这是一个地址
        arrayList.add(123);

        //add()
        arrayList.add(2,"lrc");

        //addAll()
        List list = Arrays.asList(new String[] {"Aa","Bb","Cc"});
        arrayList.addAll(list);//
        System.out.println(arrayList);//[Java, 123, lrc, [I@87f383f, 123]

        //get()
        System.out.println(arrayList.get(5));//Aa

        //indexOf()     lastIndexOf()
        System.out.println(arrayList.indexOf(123));//1
        System.out.println(arrayList.indexOf("LRC"));//-1
        System.out.println(arrayList.lastIndexOf(123));//4

        //remove()
        System.out.println(arrayList.remove(2));
        System.out.println(arrayList);

        //set()
        arrayList.set(3,"RRR");
        System.out.println(arrayList);
    }
}
