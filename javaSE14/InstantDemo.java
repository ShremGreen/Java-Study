package API;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantDemo {
    @Test
    public void test2() {
        //now( ):获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-11-12T08:55:53.484832300Z
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-11-12T16:55:53.484832300+08:00
        //toEpochMilli():获取自1970年1月1日0时0分秒(UTC) 开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //ofEpochMilli():通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1636707353484l);
        System.out.println(instant1);
    }
}