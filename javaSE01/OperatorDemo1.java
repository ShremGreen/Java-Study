class OperatorDemo1 {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		//boolean c = (a++ == 3 & b++ == 4);
		//boolean c = (a++ == 3 && b++ == 4);
		//boolean c = (++a == 3 & b++ == 4);
		boolean c = (++a == 3 && b++ == 4);
		System.out.println("c:" + c + "  " + "a:" + a + "  " + "b:" + b);
	}
}