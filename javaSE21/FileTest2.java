package IO;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/*
File类的获取功能
public String getAbsolutePath()//获取绝对路径
public String getPath()//获取路径
public String getName()//获取名称
public String getParent()//获取上层文件目录路径。若无，返回null
public long length()//获取文件长度（即：字节数）。不能获取目录的长度
public long lastModified()//获取最后一次的修改时间，毫秒值

注意是文件目录
public String[] list()//获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles()//获取指定目录下的所有文件或者文件目录的File数组

File类的重命名功能
public boolean renameTo(File dest)//把文件重命名为指定的文件路径
 */
public class FileTest2 {
    @Test
    public void test() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\MyCodes\\codes\\IDEA_code\\mod01\\src");

        System.out.println(file1.getAbsolutePath());//E:\MyCodes\codes\IDEA_code\mod01\hello.txt
        System.out.println(file1.getPath());//hello.txt
        System.out.println(file1.getName());//hello.txt
        System.out.println(file1.getParent());//null
        System.out.println(file1.length());//3
        System.out.println(new Date(file1.lastModified()));//1638670275938  Sun Dec 05 10:11:15 CST 2021

        //错误写法
        //System.out.println(file2.list());//[Ljava.lang.String;@74a10858   因为返回值是数组

        //正确写法  循环输出数组内容
        String[] list = file2.list();
        for(String str : list) {
            System.out.println(str);//内容为src下所有目录
        }

        File[] files = file2.listFiles();
        for(File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test2() {
        //File类的重命名功能
        //public boolean renameTo(File dest)//把文件重命名为指定的文件路径
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\MyCodes\\codes\\IDEA_code\\mod01\\src\\IO\\package_1\\newHello.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }
}
