package IO;

import org.junit.Test;

import java.io.*;

/*
缓冲流（处理流）
作用: 提升数据读取速度

*/
public class IODemo3 {
    @Test
    public void test() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcfile = new File("憨狗.jpg");
            File destfile = new File("憨狗2.jpg");
            //造文件流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);
            //造处理流  处理当前文件流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //read  write
            int len;
            byte[] buffer = new byte[10];
            while((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流   先关闭外部流，再关闭内部流   关闭外层流的同时系统会自动关闭内层的流
            try {
                if(bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
