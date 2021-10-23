package JavaSE.API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
throws  异常处理    特点：向上抛不会被处理
 */
public class ExceptionDemo05 {
    public static void main(String[] args) throws IOException{
        try {
            method2();//直接调用依然显示异常，这里可以继续抛，但是推荐使用try-catch-finally
        } catch(IOException e) {
            e.printStackTrace();
        }

        method3();//不会异常，因为已经被处理掉
    }
    public static void method3() {
        try {
            method1();//直接调用依然显示异常，这里可以继续抛，但是推荐使用try-catch-finally
        } catch(IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
    public static void method2() throws IOException{
        method1();//直接调用会出现编译异常，说明throws并没有处理掉该异常，需要继续throws
    }
    public static void method1() throws IOException, FileNotFoundException{//后者是前者的子类
        File file = new File("E:\\develop\\hello.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while(data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
