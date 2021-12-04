package Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo2 {
    @Test
    public void test1() {
        Son son = new Son();
        Integer[] arr = new Integer[]{2,31,5,99};

        List<Integer> list = son.methods(arr);
    }
}

class Father<T> {
    private String name;
    private int age;
    private T sign;

    public Father() {}
    public Father(String name, int age, T sign) {
        this.name = name;
        this.age = age;
        this.sign = sign;
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

    public T getSign() {
        return sign;
    }

    public void setSign(T sign) {
        this.sign = sign;
    }
}

class Son extends Father<Integer> {//此时T为Integer
    public static <E> List<E> methods(E[] arr) {
        ArrayList<E> list = new ArrayList<E>();
        for(E e : arr) {
            list.add(e);
        }
        return list;
    }
}