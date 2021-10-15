/*
代码块
*/

class DemoMass {
	static {//静态代码块在调用构造方法前执行，优先级大于构造代码块
		System.out.println("静态代码块");
	}
	
	{//构造代码块在调用构造方法前执行，在静态代码块后执行
		System.out.println("构造代码块");
	}
	
	public DemoMass() {//创建构造方法
		System.out.println("构造方法");
	}
}

class Mass {
	static {//创建测试类的静态代码块
		System.out.println("测试类的静态代码块");
	}
	
	public static void main(String[] args) {
		System.out.println("main方法");
		
		DemoMass d1 = new DemoMass();//调用构造方法
	    DemoMass d2 = new DemoMass();//调用构造方法+1
	}
}

/*输出：
main方法
静态代码块
构造代码块
构造方法
构造代码块
构造方法
*/