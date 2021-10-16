package java_study_03;
/*
 * 1.==和equals区别	equals只比较地址值是否相同，需要重写。而String类中重写了equals()方法，比较的是内容是否相同
 * 2.String s2 = "hello";和String s1 = new String("hello");的区别
 * 前者在字符串常量池（方法区）中开辟地址和内存，后者还会在堆内存中开辟
 * */
public class StringCompare {
	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = "hello";
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		//看程序写结果
		String s3 = "hello";
		String s4 = "world";
		String s5 = "helloworld";
		
		System.out.println(s5 == s3 + s4);//false
		System.out.println(s5.equals(s3 + s4));//true
		
		//这里编译前先进行拼接再比较，也就是说编译时相当于下一条判断
		System.out.println(s5 == "hello" + "world");//true
		
		System.out.println(s5 == "helloworld");//true
		}
}
