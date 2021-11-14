package API;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
/*
方式二：定制排序：java.util.Comparator

 */
public class ComparableDemo02 {
    @Test
    public void test01() {
        String[] arr = {"zdf","ADF","EGR","AAA","kex"};
        Arrays.sort(arr,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String) {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return str1.compareTo(str2);
                } throw new RuntimeException("类型错误");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02() {
        Weapon[] arr = new Weapon[5];
        arr[0] = new Weapon("H环首刀",34);
        arr[1] = new Weapon("D点钢枪",43);
        arr[2] = new Weapon("Y鱼肠剑",12);
        arr[3] = new Weapon("F方天戟",65);
        arr[4] = new Weapon("G鬼头刀",34);

        //对以上武器进行排列 先排列姓名，再排列价格
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Weapon && o2 instanceof Weapon) {
                    Weapon weapon1 = (Weapon) o1;
                    Weapon weapon2 = (Weapon) o2;
                    if(weapon1.getName().equals(weapon2.getName())) {
                        return Double.compare(weapon1.getPrice(),weapon2.getPrice());
                    }else return weapon1.getName().compareTo(weapon2.getName());
                }
                throw new RuntimeException("类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
