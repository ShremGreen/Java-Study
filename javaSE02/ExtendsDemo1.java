/*
¶à²ã¼Ì³Ð
*/

class Grandfather {
	public void show() {
	System.out.println("Ò¯Ò¯");
	}
}

class Father extends Grandfather {
	public void method() {
	System.out.println("µùµù");
	}
}

class Son extends Father {}

class ExtendsDemo1 {
	public static void main(String[] args) {
		Son s = new Son();
		s.show();
		s.method();
	}
}