package java_study_03;
/*
 * equals(Object obj)
 * equalsIgnoreCase(String str)
 * contains(String str)
 * startsWith(String str)
 * endsWith(String str)
 * isEmpty()
 * */
public class StringDemo1 {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "Hello";
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.startsWith("hel"));
		System.out.println(s1.contains("ell"));
		System.out.println(s1.contains("ho"));
		System.out.println(s1.endsWith("lo"));
		String s3 = "";
		//String s4 = null;
		System.out.println(s3.isEmpty());
		//System.out.println(s4.isEmpty());//报错，因为null根本不存在
	}
}
