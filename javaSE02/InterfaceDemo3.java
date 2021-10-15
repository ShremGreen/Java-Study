/*

*/

interface Father {
	public abstract void show1();
}

interface Mother {
	public abstract void show2();
}

interface Sister extends Father,Mother {//接口间可以多继承
	//接口之间继承不需要方法重写
}

//类实现接口其实默认有继承关系，继承自Object
//class Son extends Object implements Father,Mother {

class Son implements Father,Mother {//类实现接口可以多实现
	public void show1() {
		System.out.println("子类实现父接口");
	}
	
	public void show2() {
		System.out.println("子类实现母接口");
	}
}

class InterfaceDemo3 {
	public static void main(String[] args) {
		Father f = new Son();
		f.show1();
		
		Mother m = new Son();
		m.show2();
		
	}
}