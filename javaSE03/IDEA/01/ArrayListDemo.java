package IDEA_code;

import java.util.ArrayList;
/*
add(...)        add(...,...)
remove(...)     remove(...,...)
set(...,...)
get(...)
size()
*/
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();//空方法
        System.out.println("al:" + al + "   size:" + al.size());

        System.out.println(al.add("lrc"));
        al.add("100");
        al.add("java");

        System.out.println("al:" + al + "   size:" + al.size());

        al.add(0,"HELLO!!");
        System.out.println("al:" + al + "   size:" + al.size());

        al.remove("lrc");
        System.out.println("al:" + al + "   size:" + al.size());
        al.remove(2);
        System.out.println("al:" + al + "   size:" + al.size());

        al.set(1,"101");
        System.out.println("al:" + al + "   size:" + al.size());
        System.out.println(al.get(0));
    }
}
