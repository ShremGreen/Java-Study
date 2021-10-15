/*
需求：定义一个员工类；
*/

class Employee {
	private String Id;
	private String name;
	private int age;
	
	//定义构造方法
	public Employee() {}
	
	//set方法
	public void setId(String Id) {
		this.Id = Id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//get方法
	public String getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	//show方法
	public void show() {
		System.out.println("员工ID：" + Id + "\n" + "员工姓名：" + name + "\n" + "员工年龄：" + age);
	}
}

class EmployeeTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId("xidian17040410032");
		e.setName("李荣春");
	    e.setAge(22);
		
		e.show();
	}
}