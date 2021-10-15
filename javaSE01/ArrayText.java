/*
需求：键盘录入数字，根据数字输出星期几
*/

import java.util.Scanner;
class ArrayText {
	public static void main(String[] args) {
		String[] strArr = {"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		
		System.out.println(strArr[i - 1]);
	}
}