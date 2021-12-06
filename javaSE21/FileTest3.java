package IO;

import org.junit.Test;
import java.io.File;

/*
需求：
利用File构造器，new一个文件目录file
1)在其中创建多个文件和目录
2)编写方法，实现删除file中指定文件的操作
 */
public class FileTest3 {
    @Test
    public void test() throws Exception{
        File file = new File("E:\\test\\file");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);

        File file1 = new File("E:\\test\\file\\nbPlus.txt");
        boolean newFile = file1.createNewFile();
        System.out.println(newFile);

        /*boolean delete = file1.delete();
        System.out.println(delete);*/
    }
}
