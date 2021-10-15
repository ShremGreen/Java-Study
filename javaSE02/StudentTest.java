/*
标准学生类最终版
需求：
成员变量  name和age
构造方法  无参 有参
成员方法  getXxx();setXxx();show()
*/

class Student {
	private String name;
	private int age;
	
	//构造方法无参
	public Student() {
	}
	
	//构造方法有参
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//两个set方法
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//两个get方法
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	//show方法
	public void show() {
		System.out.println("name:" + name + "   age:" + age);
	}
}

class StudentTest {
	public static void main(String[] args) {
		//调用方法1
		Student s1 = new Student();
		s1.setName("李荣春");
		s1.setAge(22);
		System.out.println("name:" + s1.getName() + "   age:" + s1.getAge());
		s1.show();
		
		//调用方法2
		Student s2 = new Student("李春",28);
		System.out.println("name:" + s2.getName() + "   age:" + s2.getAge());
		s2.show();
	}
}