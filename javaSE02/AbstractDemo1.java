/*
抽象类练习
猫狗案例

猫狗继承自动物类
动物类须定义变量name、age、eat()；

*/

abstract class Animal {
	private String name;
	private int age;
	
	public Animal() {}
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	//抽象方法
	public abstract void eat();
}

//定义狗类
//变量全部继承
//构造方法有参
//成员方法抽象
class Dog extends Animal {
	public Dog() {}
	public Dog(String name, int age) {
		super(name, age);//访问父类有参静态，将两个参数的子父类联系起来
	}
	
	public void eat() {
		System.out.println("狗啃骨头");
	}
}

class AbstractDemo1 {
	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.setName("小黑");
		d.setAge(2);
		System.out.println("名字：" + d.getName() + "年龄" + d.getAge());
		
		d = new Dog("小花", 1);//直接赋值，多态
		d.eat();
		System.out.println("名字：" + d.getName() + "年龄" + d.getAge());
	}
}