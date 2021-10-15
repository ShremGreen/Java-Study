class OperatorDemo {
	public static void main(String[] args) {
		System.out.println("hello"+'a'+1);
		System.out.println('a'+1+"hello");
		int a = 10;
		int b = 20;
	    b += a;
		System.out.println(b);
		short s = 1;
		//s = s + 1	,显示精度问题
		s += 1;//等价于s = (s的数据类型) (s + 1)；
		System.out.println（s）；
		}
}