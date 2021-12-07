package IO;

import org.junit.Test;

import java.io.*;

/*
通过传输视频实现比较节点流和处理流的运行速度
 */
public class IOTest1 {
    @Test
    public void test() {
        String srcPath = "C:\\Users\\10627\\Desktop\\video.avi";
        String destPath1 = "C:\\Users\\10627\\Desktop\\video1.avi";
        String destPath2 = "C:\\Users\\10627\\Desktop\\video2.avi";

        long t1 = System.currentTimeMillis();
        fileStream(srcPath,destPath1);
        long t2 = System.currentTimeMillis();
        System.out.println("节点流传输时间: " + (t2 - t1) + "ms");//616ms

        long t3 = System.currentTimeMillis();
        bufferStream(srcPath,destPath2);
        long t4 = System.currentTimeMillis();
        System.out.println("处理流传输时间: " + (t4 - t3) + "ms");//170ms
    }

    public void fileStream(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            int len;
            byte[] cbuf = new byte[1024];
            while((len = fis.read(cbuf)) != -1) {
                fos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bufferStream(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //造文件流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //造处理流  处理当前文件流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //read  write
            int len;
            byte[] buffer = new byte[1024];
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
