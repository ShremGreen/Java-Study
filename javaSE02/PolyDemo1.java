/*
¶àÌ¬µÄÃ¨¹·°¸Àý
*/

class Animal {
	public void eat() {
		System.out.println("³Ô...");
	}
	
	public void sleep() {
		System.out.println("Ë¯...");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("³ÔÓã");
	}
	
	public void sleep() {
		System.out.println("Å¿×ÅË¯");
	}
}

class AnimalTool {
	private AnimalTool() {}
	
	public static void useAnimal(Animal a) {
		a.eat();
		a.sleep();
	}
}

class PolyDemo1 {
	public static void main(String[] args) {
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		
		AnimalTool.useAnimal(c1);
		AnimalTool.useAnimal(c2);
	}
}