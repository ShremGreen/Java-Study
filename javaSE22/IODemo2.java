package IO;

import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
需求：
字符流实现图片复制
通过InputStream和OutputStream实现图片的复制
 */

public class IODemo2 {
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File("憨狗.jpg");
            File file2 = new File("憨狗1.jpg");

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            int len;
            byte[] cbuf = new byte[5];
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
}
