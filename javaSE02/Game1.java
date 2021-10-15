/*
猜数字
*/

import java.util.Scanner;
class Game1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = (int) (Math.random() * 100 + 1);
		
		while(true) {
			System.out.println("请输入数字：");
			int b = sc.nextInt();
			if(a > b) {
				System.out.println("小了");
			} else if(a < b) {
				System.out.println("大了");
			} else {
				System.out.println("猜中了！！！");
				break;//注意这里跳出一层循环，而if不是循环
			}
		}
	}
}