package API;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import javax.security.auth.callback.LanguageCallback;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
/*
新的日期时间方法

 */
public class DateTimeDemo01 {
    @Test
    public void testDate() {
        //如果用Date会有偏移量
        Date date = new Date(2021 - 1900,11 - 1,12 - 1);
        System.out.println(date);//Mon Dec 12 00:00:00 CST 3921

        //JDK8后
        //now()方法
        LocalDate l1 = LocalDate.now();
        LocalTime l2 = LocalTime.now();
        LocalDateTime l3 = LocalDateTime.now();

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        //of方法      get()方法
        LocalDateTime localDateTime = LocalDateTime.of(2021, 11, 12, 16, 18);
        System.out.println(localDateTime.getDayOfMonth());//12

        //with()方法  设定时间并返回
        System.out.println(localDateTime.withDayOfMonth(6));//2021-11-06T16:18

        //plus()方法  增加时间    minus()方法  减少时间
        System.out.println(localDateTime.plusDays(20));//2021-12-02T16:18
    }
}
