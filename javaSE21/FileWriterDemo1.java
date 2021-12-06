package IO;

import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
从内存中写出数据到硬盘的文件里
注意：
写出操作如果不存在文件，默认新建该文件

FileWriter(File file)
       如果存在文件,覆盖该文件
FileWriter(File file, boolean append)
       append=true  继续写出
       append=false 覆盖文件
 */
public class FileWriterDemo1 {
    @Test
    public void test() {
        FileWriter fw = null;//创建输入流或输出流对象
        try {
            File file = new File("hello1.txt");
            fw = new FileWriter(file,true);

            fw.write("I have a dream!\n");
            fw.write("Don't you?");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
