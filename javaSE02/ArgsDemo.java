/*
1.类之间可以互相调用
形式参数问题
*/

class Add {
	public int sum(int a, int b) {
		return a + b;
	}
}

class Chenshu {
	public void hua() {
		System.out.println("加法结果是：");
	}
}

class Diaoyong {
	//创建一个形式参数是类类型（类属于引用类型）的的方法，格式是：引用类型 对象名
	public void chuan(Chenshu c) {
		c.hua();
	}
}

class ArgsDemo {
	public static void main(String[] args) {
		
		Diaoyong d = new Diaoyong();//创建对象时需要加（）
		Chenshu c = new Chenshu();//调用之前必须先创建对象
		d.chuan(c);//在Diaoyong类中找到chuan方法，通过参数找到Chenshu类再打印
		
		Add a = new Add();
		int b = a.sum(3,4);
		System.out.println(b);

		
	}
}