package Collection.test_Generic;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    //比较器compareTo()    返回负数/0/正数
    //按照日期从大到小
    @Override
    public int compareTo(MyDate date) {
        int year = this.getYear() - date.getYear();
        if(year != 0) {
            return year;
        } else{
            int month = this.getMonth() - date.getMonth();
            if(month != 0) {
                return month;
            } else {
                int day = this.getDay() - date.getDay();
                if(day != 0) {
                    return day;
                } else return 0;
            }
        }
    }
}
