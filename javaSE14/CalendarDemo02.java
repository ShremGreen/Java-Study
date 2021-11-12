package API;
/*
get()
set()
add()
getTime()
setTime()
 */
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

public class CalendarDemo02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getClass());//class java.util.GregorianCalendar
        System.out.println(cal.getTime());//Fri Nov 12 09:11:48 CST 2021

        //get() set()
        int i = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);//12
        cal.set(Calendar.DAY_OF_MONTH,3);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//3

        //add()
        cal.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//6
        cal.add(Calendar.DAY_OF_MONTH,-6);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//31

        //getTime()     Calendar 化为 Date
        Date date1 = cal.getTime();
        System.out.println(date1);//Sun Oct 31 09:23:37 CST 2021
        //setTime()     Date 化为 Calendar
        Date date2 = new Date();
        cal.setTime(date2);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//12
    }
}
