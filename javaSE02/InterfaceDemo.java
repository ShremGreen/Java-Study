/*
接口：
1.interface 接口名 {}
2.类实现接口用implements表示
class 类名 implements 接口名 {}
3.接口不能实例化，但是可通过多态的方式进行实例化
4.接口的子类一般是具体类（也可以是抽象类，但是意义不大），要重写接口中所有抽象方法
*/

interface AnimalTrain {
	public abstract void jump();
}

class Dog implements AnimalTrain {
	public void jump() {
		System.out.println("实现跳高");
	}
}

class InterfaceDemo {
	public static void main(String[] args) {
		//AnimalTrain a = new AnimalTrain();
		//a.jump();
		
		AnimalTrain at = new Dog();
		at.jump();
	}
}