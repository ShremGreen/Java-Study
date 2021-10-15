/*
for循环程序:输出所有的水仙花数
水仙花数是个三位数，各位数字立方和等于其本身。
153 = 1^3 + 5^3 + 3^3
*/

class ForDemo {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i = 100; i <= 999; i++) {
			int a = i%10;
			int b = i/10%10;
			int c = i/10/10%10;
			
			if((a*a*a + b*b*b + c*c*c) == i) {
				System.out.println(i);
				sum += 1; //sum ++;
			}
		}
		System.out.println("一共有" + sum + "个水仙花数");
	}
}