package IO;

import org.junit.Test;

import java.io.File;

/*
File类的使用：
1.File类的一个对象代表一个文件或文件目录（文件夹）
2.File类声明在java.io包下

实例化
File(string fiLePath)
FiLe(string parentPath,String childPath)
FiLe(File parentFiLe,String childPath)
*/
public class FileTest1 {
    @Test
    public void test1() {
        //实例化1
        //相对路径
        File file1 = new File("hello.txt");//hello.txt
        //绝对路径
        File file2 = new File("E:\\MyCodes\\codes\\IDEA_code\\mod01\\src\\IO");//E:\MyCodes\codes\IDEA_code\mod01\src\IO

        //实例化2
        File file3 = new File("E:\\MyCodes\\codes\\IDEA_code\\mod01","src");//E:\MyCodes\codes\IDEA_code\mod01\src

        //实例化3
        File file4 = new File(file3,"IO");//E:\MyCodes\codes\IDEA_code\mod01\src\IO
        System.out.println(file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);

        
    }
}
