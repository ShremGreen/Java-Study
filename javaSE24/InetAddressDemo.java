package IO;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
IP地址
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("169.254.206.204");
            System.out.println(ia);///169.254.206.204

            InetAddress ia1 = InetAddress.getByName("www.baidu.com");
            System.out.println(ia1);//www.baidu.com/14.215.177.39

            //获取本地IP
            InetAddress ia2 = InetAddress.getByName("127.0.0.1");
            InetAddress ia3 = InetAddress.getLocalHost();
            System.out.println(ia2);
            System.out.println(ia3);//DESKTOP-T6NIQP7/10.170.50.72

            System.out.println(ia3.getHostName());//DESKTOP-T6NIQP7
            System.out.println(ia3.getHostAddress());//10.170.50.72

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
