package API;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/*
DateTimeFormatter
解析或格式化时间
 */
public class DateTimeFormatterDemo {
    @Test
    public void test1() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //ISO_LOCAL_TIME = new DateTimeFormatterBuilder();

        //方式一
        //格式化   日期到字符串
        LocalDateTime ldt = LocalDateTime.now();
        String s = formatter.format(ldt);
        System.out.println(ldt);//2021-11-13T09:48:36.886730900
        System.out.println(s);//2021-11-13T09:48:36.8867309
        //解析    字符串到日期
        TemporalAccessor parse = formatter.parse("2021-11-23T21:28:36.886");
        System.out.println(parse);

        //方式二
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(formatter1.format(LocalDateTime.now()));//2021年11月13日

        //方式三   自定义（常用）
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日  hh:mm:ss");
        System.out.println(formatter2.format(LocalDateTime.now()));//2021年11月13日  10:10:37
    }
}
