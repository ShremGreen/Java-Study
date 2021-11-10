package API;

import java.util.Date;

/*
返回日期和时间的方法：
1.System类
        currentTimeMillis()   时间戳
2.java.util.Date类
        toString()  年月日时分秒
        getTime()
3.java.sql.Date类
        数据库 toString返回时间（年月日）
 */
public class DateDemo {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();//1636526833434
        System.out.println(t1);

        //无参构造方法
        System.out.println(new Date().toString());//Wed Nov 10 14:47:13 CST 2021
        System.out.println(new Date().getTime());//1636526833460

        //带参构造方法
        System.out.println(new Date(2145666044).toString());//Mon Jan 26 04:01:06 CST 1970
    }
}
