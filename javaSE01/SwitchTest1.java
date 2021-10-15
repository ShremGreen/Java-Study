/*

*/
import java.util.Scanner;

class SwitchTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入：");
		String s = sc.nextLine();
		
		switch(s) {
			case "yes":
			     System.out.println("您输入了yes");
				 break;
			case "no":
			     System.out.println("您输入了no");
				 break;
			default:
			     System.out.println("输入有误");
				 //break;
		}
	}
}