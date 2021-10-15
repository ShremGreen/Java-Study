/*
final关键字

修饰类		错误: 无法从最终X进行继承
修饰方法	错误: Y中的show()无法覆盖X中的show()
修饰变量	错误: 无法为最终变量a分配值
*/

/*final class X {
	
}*/

class X {
	final int a = 10;
	public void show() {
		System.out.println("这是被final修饰的父类方法");
	}
}

class Y extends X {
	public void show() {
		System.out.println("这是子类方法");
	}
	
	public void method() {
		//int a = 20;
		System.out.println(a);
	}
}

class FinalDemo {
	public static void main(String[] args) {
		Y y = new Y();
		y.show();
		y.method();
	}
}