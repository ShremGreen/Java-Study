/*
需求：
在测试类中使用子类特有功能method()

方法1	new Son();
		可行，但是new会增加内存，并且逻辑上不合理（2个儿子）
方法2	Son s = (Son) f;
		把父类的引用强制转型为子类的引用（向下转型）
		不会新增内存（因为没有new）
*/

class Father {
	public void show() {
		System.out.println("父类show方法");
	}
}

class Son extends Father {
	public void show() {
		System.out.println("子类show方法");
	}
	
	public void method() {
		System.out.println("子类method方法");
	}
}

class PolyDemo2 {
	public static void main(String[] args) {
		Father f = new Son();
		
		f.show();
		//f.method();
		
		/*
		Son s = new Son();
		s.method();
		*/
		
		Son s = (Son) f;
		s.method();
	}
}