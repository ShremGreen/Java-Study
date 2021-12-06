package IO;
import java.io.File;

/*
需求:
遍历指定目录所有文件名称，包括子文件目录中的文件
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("E:\\test");
        printAllFiles(file);

    }

    public static void printAllFiles(File file) {

        File[] files = file.listFiles();
        for(File f : files) {
            if(f.isDirectory()) {
                printAllFiles(f);//递归调用，继续深入
            } else {
                System.out.println(f.getName());//nbPlus.txt	电子签名.jpg		new.txt
                System.out.println(f.length());
            }
        }
    }
}
