/*
方法重写
*/

class Phone {
	public void call(String name) {
		System.out.println("call" + name);
	}
}

class NewPhone extends Phone {
	public void call(String name) {
		super.call(name);
		
		//System.out.println("call" + name);//打电话应该是一个最基础的继承方法，而不是再写一边
		System.out.println("send massage to" + name);
	}
}

class ExtendsDemo6 {
	public static void main(String[] args) {
		NewPhone np = new NewPhone();
		
		np.call("李荣春");
	}
}