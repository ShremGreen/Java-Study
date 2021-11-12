package API;

/*
SimpleDateFormat
日期的格式化和解析

格式化：将时间转化为字符串
format()
解析：将字符串转换为时间
parse()
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo02 {
    public static void main(String[] args) {
        //无参构造
        SimpleDateFormat simDate = new SimpleDateFormat();

        //格式化   对Date类进行格式化，转化为字符串  日期Date到String
        Date date = new Date();
        System.out.println(date);
        String newDate = simDate.format(date);
        System.out.println(newDate);

        //解析    String到Date
        String sDate = "2021/11/11 上午9:30";//输入错误，抛出异常
        try {
            date = simDate.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);

        //带参构造  自定义格式
        SimpleDateFormat simDate1 = new SimpleDateFormat("yyyy.MM.dd  hh:mm:ss");
        //格式化   Date转化为String
        Date d = new Date();
        System.out.println(d);
        System.out.println(simDate1.format(d));

        //解析    String到Date
        String s = "2002.01.03  01:20:33";
        try {
            d = simDate1.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
    }
}
