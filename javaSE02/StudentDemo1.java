/*
封装初级:
private
注意：被private修饰的成员只能在本类中访问
*/
class Student {
	private String name;
	private int age;
	
	public void setAge(int a) {
		if(a < 0 || age > 120) {
			System.out.println("错误");
	}else {
		age = a;
	}
}

    public void setName(String n) {
		name = n;
	}
	
	public void show() {
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);
	}
}


class StudentDemo1 {
	public static void main(String[] args) {
		Student s = new Student();
		s.show();
		System.out.println("--------------");
		
		//s.name = "李荣春";
		//s.age = 22;
		s.setAge(23);
		s.setName("李荣春");
		s.show();
	}
}