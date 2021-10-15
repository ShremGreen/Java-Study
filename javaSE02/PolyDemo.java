/*
多态中成员访问特点

成员变量	编译看左边，执行看左边（因为对象类是父类，调用父类变量）
构造方法	创建子类对象的时候，访问父类构造方法对父类进行初始化
成员方法	编译看左边，执行看右边（成员方法存在方法重写，父类被子类覆盖，显示子类）
静态方法	编译看左边，执行看左边（静态只和类相关，不算方法重写，仍是父类）
*/

class Father {
	int num = 2;
	
	public void show() {
		System.out.println("父类show方法");
	}
	
	public static void method() {
		System.out.println("父类静态方法");
	}
}

class Son extends Father {
	int num = 3;
	int num1 = 4;
	
	public void show() {
		System.out.println("子类show方法");
	}
	
	public static void method() {
		System.out.println("子类静态方法");
	}
}

class PolyDemo {
	public static void main(String[] args) {
		//格式：父类 f = new 子类();
		Father f = new Son();
		
		System.out.println(f.num);
		//System.out.println(f.num1);//此时提示找不到符号
		//因为是在父类中寻找num1，而父类中没有
		
		f.show();
		f.method();
	}
}