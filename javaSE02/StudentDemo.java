/*
在一个java文件中写两个类：基本类和测试类
注意：文件名和测试类名一致
*/

//定义第一个类
class Student {
	String name;//null
	int age;//0
	String address;//null
	//定义学生类下的方法
	public void study() {
		System.out.println("学习中……");
	}
	
	public void relax(String name) {
		System.out.println("和" +name+ "娱乐中……");
	}
	
	public void rest() {
		System.out.println("休息中……");
	}
}

class StudentDemo {
	public static void main(String[] args) {
		Student s = new Student();
		
		s.name = "李荣春";
		s.age = 22;
		s. address = "山东";
		
		System.out.println(s.name + "     " + s.age + "     " + s.address);
		
		s.study();
		s.relax("lala");
		s.rest();
}
}