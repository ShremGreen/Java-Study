package API;

import java.util.Arrays;

/*
Comparable接口：
像String、包装类等，内部都实现了Comparable接口，并重写了compareTo()方法

重写compareTo()规则：
1.比较结果由小到大排列  分别对应负数、零、正数
2.对于自定义类的排序，需要实现Comparable接口并重写compareTo()方法
*/

public class ComparableDemo01 {
    public static void main(String[] args) {
        Weapon[] arr = new Weapon[5];
        arr[0] = new Weapon("环首刀",34);
        arr[1] = new Weapon("点钢枪",43);
        arr[2] = new Weapon("鱼肠剑",12);
        arr[3] = new Weapon("方天戟",65);
        arr[4] = new Weapon("鬼头刀",34);
        Arrays.sort(arr);//由于自定义了compareTo()方法，
        System.out.println(Arrays.toString(arr));//toString()已经重写
    }
}

class Weapon implements Comparable{
    private String name;
    private double price;

    public Weapon() {
    }

    public Weapon(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o){
        //判断子父类关系
        if(o instanceof Weapon) {
            //比较价格，首先进行强转，化为同一类型再进行价格比较
            Weapon weapon = (Weapon) o;
            if(this.price > weapon.price) {
                return 1;
            } else if(this.price == weapon.price) {
                return -this.name.compareTo(weapon.name);
            } else {
                return -1;
            }
        } else {
            throw new RuntimeException("比较类型错误！");//运行时异常是不需要处理的
        }
    }
}