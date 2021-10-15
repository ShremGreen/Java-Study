
//实现两整数的交换

class OperatorTest {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		//1.加一个变量
		//2.位异或
		/*a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		//3.加减法
		a = a + b;
		b = a - b;
		a = a - b;*/
		//4.一句话
		b = (a + b) - (a = b);
		
		System.out.println("a:" + a + "b:" + b);
	}
}