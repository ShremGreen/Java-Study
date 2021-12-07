package IO;

import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
需求：
通过FileReader和FileWriter实现文件的复制
1.实例化File
2.实例化FileReader和FileWriter
3.read()    write() 循环读写
4.关闭流
5.异常处理
 */
public class IODemo1 {
    @Test
    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //实例化File
            File file1 = new File("hello1.txt");
            File file2 = new File("hello2.txt");
            //实例化FileReader和FileWriter
            fr = new FileReader(file1);
            fw = new FileWriter(file2);
            //read()    write()
            int length;
            char[] cbuf = new char[5];
            while((length = fr.read(cbuf)) != -1) {
                fw.write(cbuf,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
