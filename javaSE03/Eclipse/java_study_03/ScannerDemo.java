package java_study_03;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		//测试1
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String b = sc.nextLine();
		//这样会造成字符串无法录入，由于有回车
		System.out.println(".......................");
		
		//解决方法1，一般不用
		int c =sc.nextInt();
		Scanner sc1 = new Scanner(System.in);
		String d = sc1.nextLine();
		//解决方法2，所有数据都以String录入，使用时转为各自形式
		
		
		
		
		//测试2
		Scanner sc2 = new Scanner(System.in);
		boolean p = sc2.hasNextFloat();//返回值为boolean，判断是否为浮点数
		System.out.println(p);
	}
}
