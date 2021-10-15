/*
if语句小题:输入月份，判断季节和上下半年
*/



import java.util.Scanner;
class IfTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入月份：");
		int x = sc.nextInt();
		
		if(x >=3 && x <=5) {
			System.out.println("春");
		}
		else if(x >=6 && x <=8) {
			System.out.println("夏");
		}
		else if(x >=9 && x <=11) {
			System.out.println("秋");
		}else System.out.println("冬");
	}
}