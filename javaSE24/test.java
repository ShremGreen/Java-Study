package IO;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
