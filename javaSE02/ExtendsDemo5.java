/*
静态代码块、构造代码块、构造方法
结果：
父类静态代码块
子类静态代码块
父类构造代码块
父类构造方法
子类构造代码块
子类构造方法

分析：
Son s = new Son();
首先加载class，此时静态代码块也被加载；先父后子
然后new，开始调用构造方法，此时依次是构造代码块，构造方法；先父后子
*/

class Father {
	static {
		System.out.println("父类静态代码块");
	}
	
	{
		System.out.println("父类构造代码块");
	}
	
	public Father() {
		System.out.println("父类构造方法");
	}
}

class Son extends Father {
	static {
		System.out.println("子类静态代码块");
	}
	
	{
		System.out.println("子类构造代码块");
	}
	
	public Son() {
		System.out.println("子类构造方法");
	}
}

class ExtendsDemo5 {
	public static void main(String[] args) {
		new Son();
	}
}