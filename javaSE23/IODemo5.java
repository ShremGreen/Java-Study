package IO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
需求：
从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。

System.in   字节流
BufferedReader  readLine()  字符流     读入一行数据

 */
public class IODemo5 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //通过转换流将System.in的字节流转化为缓冲流BufferedReader的字符流
            InputStreamReader isr = new InputStreamReader(System.in);

            //字符缓冲流
            br = new BufferedReader(isr);

            while(true) {
                //readLine()
                String str = br.readLine();//用于存储数据
                if("e".equals(str) || "exit".equals(str)) {
                    break;
                }
                String s = str.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
