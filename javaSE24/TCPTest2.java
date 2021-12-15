package IO;

import org.junit.Test;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
需求：客户端发送文件到服务端，服务端接收文件并保存在本地
*/
public class TCPTest2 {
    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //Socket
            socket = new Socket(InetAddress.getByName("10.170.38.10"),52321);
            //输入流
            fis = new FileInputStream(new File("憨狗.jpg"));
            //输出流   需要通过Socket和服务器端建立连接
            os = socket.getOutputStream();
            //设置读入写出步骤
            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1) {
                os.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        InputStream is = null;//ServerSocket     socket      InputStream
        FileOutputStream fos = null;
        try {
            //ServerSocket
            ss = new ServerSocket(52321);
            //Socket
            Socket socket = ss.accept();
            is = socket.getInputStream();
            //输出流   写出文件
            fos = new FileOutputStream(new File("C:\\Users\\10627\\Desktop\\newPicture.jpg"));
            //设置读入写出
            byte[] buf = new byte[1024];
            int len;
            while((len = is.read(buf)) != -1) {
                fos.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
