/*
接口中成员特点：
变量：
		接口中的变量默认是常量，并且是静态的
		默认修饰符：public static final
构造方法:
		没有构造方法
		所有的接口子类都继承自Object
成员方法：
		只能是抽象方法
		默认修饰符：public abstract
*/

interface Inter {
	public int num = 10;
	public final int num1 = 20;
	
	//错误: 需要<标识符>
	//public Inter() {}//说明接口中没有构造方法
	
	//public void show() {}//错误: 接口方法不能带有主体,说明接口方法都是抽象的
	
	//abstract void show();//错误：正在尝试分配更低的访问权限; 以前为public
	//说明默认修饰符是public abstract
}

class InterImpl extends Object implements Inter {
	public InterImpl() {
		super();
	}
	
	void show() {}
}

class InterfaceDemo1 {
	public static void main(String[] args) {
		Inter i = new InterImpl();
		System.out.println(i.num);
		System.out.println(i.num1);
		
		//i.num = 1;//错误: 无法为最终变量num分配值
		//i.num1 = 2;//错误: 无法为最终变量num1分配值
		//说明接口中变量都不能重新赋值，全是常量
		
		//由于静态可以使用类名调用，下面测试
		System.out.println(Inter.num);//结果正常，说明都是静态的
		
		//Inter it = new Inter();
		
	}
}
