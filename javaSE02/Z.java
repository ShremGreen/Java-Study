/*
结果：yxyz


*/
class X {
	Y y = new Y();
	X() {
		System.out.println("x");
	}
}

class Y {
	Y() {
		System.out.println("y");
	}
}

class Z extends X {
	Y y = new Y();//调用y构造方法
	
	Z() {
		super();//子类构造函数内开头相当于有super();
		System.out.println("z");
	}
	
	{
		System.out.println("123");
	}
	
	public static void main(String[] args) {
		new Z();//匿名对象调用z构造方法
		
		//没有new Z();时，无运行结果？？？
	}
}