/*
private和get、set
Java需要做到见名知意，但是会出现age = age 的情况，根据就近原则，最终结果为空。
这时需要用到this关键字，用来代表当前类的一个对象
*/

class Student {
	private String name;
	private int age;
	
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
}

class PrivateTest1 {
	public static void main(String[] args) {
		Student s = new Student();
		
		s.setName("李荣春");
		s.setAge(22);
		
		System.out.println("name:" + s.getName() + "   age:" + s.getAge());
	}	
}