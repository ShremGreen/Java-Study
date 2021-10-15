/*
继承
子类不能继承父类私有方法和变量
*/

class Father {
	private int a = 12;
	public int b = 21;
	
	private void method() {
		System.out.println("父类私有方法");
		System.out.println(a);
		System.out.println(b);
	}
	
	public void show() {
		System.out.println("父类公共方法");
		System.out.println(a);
		System.out.println(b);
	}
	
	
}

class Son extends Father {
	public void function() {
		
		//System.out.println(a);//a可以在Father中访问private
		System.out.println(b);
	}
}

class ExtendsDemo2 {
	public static void main(String[] args) {
		Son s = new Son();
		
		s.show();
		//s.method();
		s.function();
	}
}