package IO;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
UDP网络通信
流程：
1. DatagramSocket与DatagramPacket
2. 建立发送端，接收端
3. 建立数据包
4. 调用Socket的发送、接收方法
5. 关闭Socket
 */
public class TCPTest3 {
    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "UDP网络通信";//传输的信息
            byte[] buf = str.getBytes();//缓冲字节数组
            InetAddress inetAddress = InetAddress.getLocalHost();//获取本地服务器的IP地址
            DatagramPacket packet = new DatagramPacket(buf,0,str.length(),inetAddress,9090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] buf = new byte[20];
            DatagramPacket packet = new DatagramPacket(buf,0,buf.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
