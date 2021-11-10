package API;
/*
String  StringBuffer    StringBuilder在效率上的区别

StringBuilder最快3ms；StringBuffer仅次于前者；String最慢0.2s
 */
public class StringDemo03 {
    public static void main(String[] args) {
        long t1;
        long t2;

        String s = new String("");
        StringBuffer sbf = new StringBuffer();
        StringBuilder sbd = new StringBuilder();

        t1 = System.currentTimeMillis();
        for(int i = 0; i < 20000; i ++) {
            s += i;
        }
        t2 = System.currentTimeMillis();
        System.out.println("String.Time\t\t" + (t2-t1));

        t1 = System.currentTimeMillis();
        for(int i = 0; i < 20000; i ++) {
            sbf.append(String.valueOf(i));
        }
        t2 = System.currentTimeMillis();
        System.out.println("StringBuffer.Time\t" + (t2-t1));

        t1 = System.currentTimeMillis();
        for(int i = 0; i < 20000; i ++) {
            sbd.append(String.valueOf(i));
        }
        t2 = System.currentTimeMillis();
        System.out.println("StringBuilder.Time\t" + (t2-t1));
    }
}
