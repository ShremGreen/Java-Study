package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
输入流
read()    返回读入的字符，如果到达文件末尾返回-1    可自动迭代
注意：
1.读取文件需要在末尾对其进行关闭close()
2.异常处理  如果前面的过程出现异常，需要保证流可以正常关闭(finally)

*/

public class FileReaderDemo1 {
    @Test
    public void test1() {
        FileReader fr = null;//将文件读入内存
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            //读入数据  read()  返回读入的字符，如果到达文件末尾返回-1    可自动迭代
            int data = fr.read();
            //通过遍历实现读取
            while(data != -1) {
                System.out.println(data + "\t" + (char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
