package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
某人从2008.6.1开始三天打鱼两天晒网，查看任意一天的事务。

思路：
原始时间化为毫秒数与设定时间相减
将毫秒数化为天数
将天数除5获得余数并进行判断
 */
public class DateTest02 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simdate = new SimpleDateFormat("yyyy.MM.dd");
        String originTime = "2008.06.01";
        //毫秒数
        Date d = simdate.parse(originTime);
        long t1 = d.getTime();
        String nowTime = simdate.format(new Date());
        long t = (simdate.parse(nowTime).getTime() - t1);
        //天数
        long dayNum = t/(24*60*60*1000) + 1;
        System.out.println(dayNum);
        //余数
        int workNum = (int) dayNum%5;
        switch(workNum) {
            case 0:
                System.out.println("今天是第" + dayNum + "天，渔夫正在晒网");
                break;
            case 1:
            case 2:
            case 3:
                System.out.println("今天是第" + dayNum + "天，渔夫正在打鱼");
                break;
            case 4:
                System.out.println("今天是第" + dayNum + "天，渔夫正在晒网");
                break;
            default:
                System.out.println("出错了！");
        }
    }
}
