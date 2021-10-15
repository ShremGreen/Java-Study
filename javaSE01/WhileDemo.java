/*
while语句:输出100-1000内水仙花数
*/

class WhileDemo {
	public static void main(String[] args) {
		int i = 100;
		int sum = 0;
		
		while(i<1000) {
			int a = i%10;
			int b = i/10%10;
			int c = i/10/10%10;
			
			if(a*a*a + b*b*b + c*c*c == i) {
				System.out.println(i);
				sum++;
			}
			i++;
		}
		System.out.println("一共有" + sum + "个水仙花数");
	}
}

