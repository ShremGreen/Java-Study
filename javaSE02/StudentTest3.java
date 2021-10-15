/*
返回值类型：
引用类型：
类		
抽象类	
接口	
*/

class Student {
	public void study() {
		System.out.println("学习...");
	}
}

class StudentDemo {
	public Student getStudy() {
		Student s = new Student();
		return s;
		
		//简化版
		//return new Student();
	}
}

class StudentTest3 {
	public static void main(String[] args) {
		 //输出study()
		 StudentDemo sd = new StudentDemo();
		 Student s = sd.getStudy();
		 s.study();
	}
}

