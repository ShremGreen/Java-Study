
class Private {
	//私有化一个变量
	private int a = 10;
	//私有化一个方法
	private void method() {
		System.out.println("method" + "   a=" + a);
	}
	//类内部调用私有化的一个方法
	public void function() {
		method();
	}
}

class PrivateTest {
	public static void main(String[] args) {
		Private p = new Private();
		//p.method();//显示不能调用私有化方法
		p.function();
	}
}