package IO;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IODemo6 {
    @Test
    public void test() {
        PrintStream ps = null;//打印流 设置自动刷新缓冲区
        try {
            FileOutputStream fos = new FileOutputStream("E:\\test\\lrc\\abc.txt");//文件流读入数据
            ps = new PrintStream(fos,true);

            if(ps != null) {
                System.setOut(ps);//通过打印流对象，设置输出设备为abc.txt
            }

            for(int i = 0; i <= 255; i ++) {
                System.out.print((char) i);
                if(i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
