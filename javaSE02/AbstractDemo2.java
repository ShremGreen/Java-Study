/*
抽象类：普通员工和经理

分析：
共性，都是公司员工，private String name;
					private String id;
					private int salary;
					public void work() {}
					共性的方法使用abstract,抽象方法
特性：
经理		有奖金
*/


//抽象类注意！！！
abstract class Employee {
	//共性，私有
	private String name;
	private String id;
	private int salary;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	
	//一定别忘了构造方法！！！！！！
	public Employee() {}
	public Employee(String name, String id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public abstract void work();
}

class Worker extends Employee {
	public Worker() {}
	public Worker(String name, String id, int salary) {
		super(name, id, salary);
	}
	
	public void work() {
		System.out.println("工人在工作...");
	}
}

class Manager extends Employee {
	private int bonus;
	
	public Manager() {}
	public Manager(String name, String id, int salary, int bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}
	
	public void work() {
		System.out.println("经理在摸鱼...");
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
}

class AbstractDemo2 {
	public static void main(String[] args) {
		//使用多态创建worker
		Employee e = new Worker("李荣春", "17040410032", 2000);
		System.out.println(e.getName() + e.getId() + e.getSalary());
		
		//使用多态创建manager,报错，因为编译的是父类（狼皮），父类没有奖金方法
		/*
		e = new manager("老李头", "17040410033", 5000, 2000);
		System.out.println(e.getName() + e.getId() + e.getSalary());
		*/
		
		//采用子类来测试
		Manager m = new Manager("老李头", "17040410033", 5000, 2000);
		System.out.println(m.getName() + m.getId() + m.getSalary());
	}
}