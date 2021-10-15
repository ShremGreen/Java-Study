/*
接口、类，
实现猫狗杂技
*/

//接口
interface Jump {
	public abstract void jump();
}

/*定义一个抽象类，
有私有name、age
抽象方法eat()
具体方法sleep()
*/
abstract class Animal {
	private String name;
	private int age;
	
	//构造方法
	public Animal() {}
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	//抽象方法eat
	public abstract void eat();
	
	//具体方法sleep
	public void sleep() {
		System.out.println("sleeping...");
	}
}

//猫类狗类
class Dog extends Animal {
	public Dog() {}
	public Dog(String name, int age) {
		super(name,age);
	}
	
	//重写eat
	public void eat() {
		System.out.println("狗啃骨头");
	}
}

class Cat extends Animal {
	public Cat() {}
	public Cat(String name, int age) {
		super(name,age);
	}
	
	//重写eat
	public void eat() {
		System.out.println("猫吃鱼");
	}
}

//会杂技的猫类狗类(继承自上面的猫狗类)
class JumpDog extends Dog implements Jump {
	//构造方法
	public JumpDog() {}
	public JumpDog(String name, int age) {
		super(name,age);
	}
	
	//重写jump方法
	public void jump() {
		System.out.println("噌！跳3m！");
	}
}

class JumpCat extends Cat implements Jump {
	//构造方法
	public JumpCat() {}
	public JumpCat(String name, int age) {
		super(name,age);
	}
	
	//重写jump方法
	public void jump() {
		System.out.println("噌！跳3m！");
	}
}

class InterfaceDemo4 {
	public static void main(String[] args) {
		//测试
		JumpDog d1 = new JumpDog("小白狗",2);
		System.out.println("名字:" + d1.getName() + "  年龄:" + d1.getAge());
		d1.eat();
		d1.sleep();
		d1.jump();
		
		System.out.println();
		
		JumpCat d2 = new JumpCat("小黑猫",1);
		System.out.println("名字:" + d2.getName() + "  年龄:" + d2.getAge());
		d2.eat();
		d2.sleep();
		d2.jump();
	}
}