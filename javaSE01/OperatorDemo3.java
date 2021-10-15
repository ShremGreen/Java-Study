/*
键盘输入数据需要先导包
import java.util.Scanner;  （在class上）
创建键盘录入对象
Scanner sc = new Scanner(System.in);
通过对象获取数据
int x = sc.nextInt();
*/
import java.util.Scanner;
class OperatorDemo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入a：");
		int a = sc.nextInt();
		System.out.println("请输入b：");
		int b = sc.nextInt();
		System.out.println("请输入c：");
		int c = sc.nextInt();
		
		int temp = ((a > b) ? a : b);
		int max = ((temp > c) ? temp : c);
		System.out.println("max=" + max);
		}
}