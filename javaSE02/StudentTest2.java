/*
接口做形式参数
*/

interface Hobby {
	public abstract void love();
}

class LoveDemo {
	public void method(Hobby h) {
		h.love();
	}
}

class Student implements Hobby {
	public void love() {
		System.out.println("学生爱唱歌");
	}
}

class StudentTest2 {
	public static void main(String[] args) {
		LoveDemo l = new LoveDemo();
		Hobby h = new Student();//多态，通过类实现接口
		l.method(h);
	}
}