/*
this和super
this输出本类成员变量中的num；
super输出父类成员变量中的num。
*/

class Father {
	int num = 1;
}

class Son extends Father {
	int num = 2;
	
	public void show() {
		int num = 3;
		
		System.out.println(num);//打印局部
		System.out.println(this.num);//打印本类成员变量
		System.out.println(super.num);//打印父类成员变量
	}
}

class ExtendsDemo3 {
	public static void main(String[] args) {
		Son s = new Son();
		
		s.show();
	} 
}