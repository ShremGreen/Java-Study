package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
FileReader
一次读入多个字符

int read(char[] arr)
每次读入一定长度的字符串，返回长度
 */
public class FileReaderDemo2 {
    @Test
    public void test() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            char[] cbuf = new char[5];
            int num;
            while((num = fr.read(cbuf)) != -1) {
                //方法1   错误
                /*for(int i = 0; i < cbuf.length; i ++) {
                    System.out.print(cbuf[i]);//lrcJava12345623
                }*/
                //方法1   正确
                for(int i = 0; i < num; i ++) {
                    System.out.println(num + "\t" +cbuf[i]);//lrcJava123456
                }

                //方法2   错误
                /*String str = new String(cbuf);
                System.out.print(str);//lrcJava12345623*/

                //方法2   正确
                /*String str = new String(cbuf,0,num);
                System.out.print(str);//lrcJava123456*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
