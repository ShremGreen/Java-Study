package java_study_01;

public abstract class AnimalDemo {
	private String name;
	private int age;
	public AnimalDemo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnimalDemo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public abstract void eat();
	public abstract void sleep();
}
