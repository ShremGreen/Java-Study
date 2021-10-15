/*
匿名对象
*/

class Student {
	public void show() {
		System.out.println("学习Java");
	}
}

class StudentDemo {
	public void method(Student s) {//s是形参
		s.show();
	}
}

class NoNameDemo {
	public static void main(String[] args) {
		Student s = new Student();
		s.show();
		System.out.println("--------------");
		
		//匿名对象作为实际参数传递
		StudentDemo sd = new StudentDemo();
		//Student ss = new Student();
		//sd.method(ss);//ss是实参
		
		//匿名对象
		//sd.method(new Student());//代替定义ss
		//匿名对象调用方法
		new StudentDemo().method(new Student());//代替定义sd
		
	}
}