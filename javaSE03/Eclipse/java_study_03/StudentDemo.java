package java_study_03;

public class StudentDemo {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.hashCode());
		System.out.println(s.getClass().getName());
		
		System.out.println(s.toString());
		System.out.println(s);
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = s1;
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s2));
	}
}
