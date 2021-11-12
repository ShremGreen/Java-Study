package API;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
需求：
将“2021.09.13”转化为java.sql.Date
 */
public class DateTest01 {

    @Test

    public void DateTest() throws ParseException {
        String s = "2021.09.13";
        //需要解析
        SimpleDateFormat simDate = new SimpleDateFormat("yyyy.MM.dd");

        Date date = simDate.parse(s);
        System.out.println(date);
        java.sql.Date sd = new java.sql.Date(date.getTime());
        System.out.println(sd);
    }
}
