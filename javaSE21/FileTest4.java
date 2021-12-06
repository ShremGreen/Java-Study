package IO;

import java.io.File;

/*
需求：
判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 */
public class FileTest4 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\file");

        //获取该目录下所有文件名称
        String[] list = file.list();
        for(String str : list) {
            if(str.endsWith(".jpg")) {
                System.out.println("jpg文件名称为：" + str);//jpg文件名称为：电子签名.jpg
            }
        }
    }
}
