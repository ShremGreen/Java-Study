/*
static静态注意事项：
 特点： 1.随着类的加载而加载
		2.可以修饰成员变量和成员方法
		3.成员变量被类的所有对象共享（定义为静态变量）
		4.可以通过类名 / 对象名调用
		5.静态中是没有this关键字的（因为static在类创建时就被创建，this随着对象而创建，静态创建时还没有this）
*/

class Teacher {
	public int a = 10;
	public static int b = 20;
	
	public void show() {
		System.out.println(a);
		System.out.println(this.a);
	}
	
	public static void method() {
		//System.out.println(this.b);
		System.out.println(b);
	}
}

class StaticDemo {
	public static void main(String[] args) {
		
		//通过对象名调用
		/*
		Teacher t = new Teacher();
		
		t.show();
		t.method();
		*/
		
		//通过类名调用
		//Teacher.show();//错误: 无法从静态上下文中引用非静态 方法 show()
		Teacher.method();
	}
}