package IO;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
字节流实现图片的加密和解密
 */
public class IODemo4 {
    @Test
    public void encrypt() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("憨狗.jpg");
            fos = new FileOutputStream("secret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1) {
                //遍历buffer并赋值
                for(int i = 0; i < len; i ++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);//将文件字节与5亦或输出
                    //byte类型在编译时会转为和一样的int类型
                }
                fos.write(buffer,0,len);
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

    @Test
    public void decrypt() {//
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("secret.jpg");
            fos = new FileOutputStream("憨狗3.jpg");

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1) {
                //遍历buffer并赋值
                for(int i = 0; i < len; i ++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);//字节两次与相同字节异或输出结果相同
                }
                fos.write(buffer,0,len);
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
