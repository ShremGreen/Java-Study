package IO;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
需求：客户端发送信息给服务器，服务器将信息显示在控制台上
 */
public class TCPTest1 {
    @Test
    public void client() {
        Socket socket = null;//端口号和IP地址组合为网络套接字Socket
        OutputStream ops = null;
        try {
            //创建Socket对象，指明IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,60000);

            //获取一个输出流
            ops = socket.getOutputStream();

            //写出数据
            ops.write("这是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ops != null) {
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    //关闭流
                    socket.close();//socket也是流，需要关闭
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(60000);

            //调用accept()，表示接收来自客户端的socket
            socket = ss.accept();

            //获取输入流
            inputStream = socket.getInputStream();

            //获取输入流的数据
            baos = new ByteArrayOutputStream();
            byte[] b = new byte[5];
            int len;
            while((len = inputStream.read(b)) != -1) {
                baos.write(b,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null) {
                try {
                    inputStream.close();
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
