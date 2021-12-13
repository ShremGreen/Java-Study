package IO;

import org.junit.Test;

import java.io.*;

public class IODemo7 {
    @Test
    public void test1() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("E:\\test\\lrc\\bcd.txt"));
            dos.writeUTF("lrcjava李荣春");
            dos.flush();//将缓冲区数据强行读入
            dos.writeInt(123);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
    }

    @Test
    public void test2() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("E:\\test\\lrc\\bcd.txt"));
            String str = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println(str);
            System.out.println(age);
            System.out.println(isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
