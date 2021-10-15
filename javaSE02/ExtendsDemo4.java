/*

*/

class Father {
	/*public Father() {
		System.out.println("父类无参");
	}
	*/
	//此时显示：无法将类 Father中的构造器 Father应用到给定类型;
	//因为父类没有无参
	
	public Father(String name) {
		System.out.println("父类有参");
	}
}

class Son extends Father {
	public Son() {
		super("123");
		System.out.println("子类无参");
	}
	
	public Son(String name) {
		//super("123");
		this();
		System.out.println("子类有参");
	}
}

class ExtendsDemo4 {
	public static void main(String[] args) {
		Son s = new Son();//子类无参构造方法，父类无参进行初始化
		Son s1 = new Son("123");//子类有参构造方法，父类无参进行初始化
	}
}