/*
抽象类特点：
1.abstract可修饰方法和类，抽象方法没有主体
2.抽象类无法实体化（Animal a2 = new Animal();）
3.继承抽象类的子类要么是抽象类，要么覆盖了父类所有的抽象方法
*/
abstract class Animal {
//Animal不是抽象的, 并且未覆盖Animal中的抽象方法eat()
//class Animal {
	
	//抽象类没有主体，空方法体也不行
	//public abstract void eat() {}
	public abstract void eat();
}

//继承抽象类的子类是抽象类
abstract class Dog extends Animal {}

//继承抽象类的子类重写父类所有抽象方法
class Cat extends Animal {
	public void eat() {
		System.out.println("这是Cat类覆盖Animal类的eat方法");
	}
}

class AbstractDemo {
	public static void main(String[] args) {
		
		//Animal a2 = new Animal();
		//错误: Animal是抽象的; 无法实例化
		
		//通过多态的方式实例化
		Animal a1 = new Cat();
		a1.eat();
	}
}