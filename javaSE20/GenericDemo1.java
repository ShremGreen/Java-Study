package Generic;

import org.junit.Test;

public class GenericDemo1 {
    @Test
    public void test1() {
        Order order = new Order();
        order.setOrderr("123");
        order.setOrderr(123);
        //如果不指明泛型，默认为Object

        //在使用自定义的泛型类时，一般需要指定类型  此处指定为Integer包装类型
        Order<Integer> order1 = new Order<Integer>("LRC",12,666);//等号左边<>为主体，等号右边<>和构造器相关

    }

    @Test
    public void test2() {
        SonOrder son = new SonOrder();
        son.setOrderr("Java");//子类继承父类并且定义了类型为String
    }
}

class Order<T> {
    String name;
    int Id;
    T orderr;

    public Order() {
    }

    public Order(String name, int Id, T order) {
        this.name = name;
        this.Id = Id;
        this.orderr = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public T getOrderr() {
        return orderr;
    }

    public void setOrderr(T order) {
        this.orderr = order;
    }
}

class SonOrder extends Order<String> {//此时 T 为String，后面无需再进行定义

}