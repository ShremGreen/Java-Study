/*
¼Ì³Ð°¸Àý
*/

class People {
	public void eat() {
		System.out.println("eat");
	}
	
	public void sleep() {
		System.out.println("sleep");
	}
}

class Student extends People {}
class Teacher extends People {}

class ExtendsDemo {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		s.sleep();
		
		Teacher t = new Teacher();
		t.eat();
		t.sleep();
	}
}