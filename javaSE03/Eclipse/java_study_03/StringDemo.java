package java_study_03;

public class StringDemo {
	public static void main(String[] args) {
		//字节数组转化为字符串
		byte[] b = {97,77,90,85,106};
		String s1 = new String(b);
		System.out.println(s1);
		
		//字符数组转化为字符串
		char[] c = {'a','c','l','李'};
		String s2 = new String(c);
		System.out.println(s2);
	}
}
