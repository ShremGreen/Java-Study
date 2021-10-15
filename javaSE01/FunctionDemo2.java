/*

*/

class FunctionDemo2 {
	public static void main(String[] args) {
		System.out.println(sum(3,4));
		System.out.println(sum(3,4,5));
		System.out.println(sum(3.32f,4,6));
	}
	
	public static int sum(int a, int b) {
		System.out.println("int");
		return a + b;
	}
	
	public static int sum(int a, int b, int c) {
		System.out.println("int");
		return a + b + c;
	}
	
	public static float sum(float a, float b, float c) {
		System.out.println("float");
		return a + b + c;
	}
}