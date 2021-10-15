/*
构造方法：
给对象进行初始化
格式：
方法名与类名一致；不需要定义返回值类型
*/

class Student {
		private String name;
		private int age;
		
		public Student() {
			System.out.println("这是无参构造方法");
	    }
		public Student(String name) {
			System.out.println("这是有参构造方法1");
			this.name = name;
		}
		public Student(int age) {
			System.out.println("这是有参构造方法2");
			this.age = age;
		}
		public void show() {
			System.out.println(name + "   " + age);
		}
}

class WuCanFangFa {
	public static void main(String[] args) {
		Student s = new Student();
		s.show();
		
		Student s1 = new Student("李荣春");
		s1.show();
		
		Student s2 = new Student(22);
		s2.show();
	}
}

