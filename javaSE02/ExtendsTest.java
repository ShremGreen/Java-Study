/*

*/

class People {
	private String name;
	private int age;
	
	public People() {}
	
	public People(String name, int age) {
		
		this.age = age;
		this.name = name;
		show();
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
	
	public void show() {
		System.out.println("name:" + name + "age:" + age);
	}
}

class Student extends People {
	//若子类为空，显示：
	//错误: 无法将类 Student中的构造器 Student应用到给定类型;
	//因为子类没有定义带参构造方法
	
	//无参
	public Student() {}
	//带参
	public Student(String name, int age) {
		//此时应注意：“老李头”和“62”仍然没有和父类建立联系
		//并且，子类中所有构造方法默认访问父类无参构造方法
		//因此需要特别通过super调用父类带参构造方法
		
		super(name,age);
	}
}

class ExtendsTest {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("李荣春");
		s1.setAge(22);
		s1.show();
		
		Student s2 = new Student("老李头", 62);
	}
}