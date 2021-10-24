package JavaSE.API;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("1");
        if(sc.hasNextLine()) {
            System.out.println("2");
        }
    }
}
