package java_study_03;

import java.util.Scanner;

public class StringTest {
	public static void main(String[] args) {
		String username = "admin";
		String password = "123456";
		
		for(int x = 0; x < 3; x ++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入用户名：");
			String n = sc.nextLine();
			System.out.println("请输入密码：");
			String p = sc.nextLine();
			
			if(n.equals(username) && p.equals(password)) {
				System.out.println("登录成功");
				break;
			} else {
				System.out.println("还有" + (2-x) + "次机会");
			}
		}
	}
}
