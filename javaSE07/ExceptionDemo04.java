package JavaSE.API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExceptionDemo04 {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        FileInputStream fis = null;
        try {
            File file = new File("E:\\develop\\hello.txt");
             fis = new FileInputStream(file);

            int data = fis.read();
            while(data != -1) {
                System.out.print((char)data);
                data = fis.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
               if(fis != null) {
                    fis.close();//这里本身也会报异常，因此需要内部嵌套一个try-catch
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
