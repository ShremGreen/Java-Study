/*
猫狗案例多态练习
*/

class Animal {
	public Animal() {}
	
	public void eat() {
		System.out.println("吃...");
	}
}

class Dog extends Animal {
	public Dog() {}
	
	public void eat() {
		System.out.println("狗啃骨头");
	}
	
	public void show1() {
		System.out.println("狗看门");
	}
}

class Cat extends Animal {
	public Cat() {}
	
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void show2() {
		System.out.println("猫捉老鼠");
	}
}

class PolyTest {
	public static void main(String[] args) {
		//向上转型
		Animal a = new Dog();
		a.eat();
		
		//向下转型
		Dog d = (Dog) a;
		d.show1();
		
		a = new Cat();
		a.eat();
		
		Cat c = (Cat) a;
		c.show2();
		
		//以下是错误内容：
		//从左到右，动物是狗、猫是狗，都不对
		//Dog d2 = new Animal();//错误: 不兼容的类型
		//Dog d3 = new Cat();//错误: 不兼容的类型
		//Dog d3 = (Dog) a;//ClassCastException: Cat cannot be cast to Dog
	}
}