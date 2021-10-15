/*
通过方法调用，实现比较两个数是否相等
*/

import java.util.Scanner;
class FunctionDemo {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("输入第一个数");
		int a = sc.nextInt();
		System.out.println("输入第二个数");
		int b = sc.nextInt();
		
		boolean c = compare(a,b);
		System.out.println(c);
	}
	
	public static boolean compare(int x,int y) {
		/*if(x == y) {
			return true;
		}else {
			return false;
	  }*/
	  
	    //boolean z = ((x == y) ? true : false);
		//return z;
		
		return (x == y);
		
	}
}