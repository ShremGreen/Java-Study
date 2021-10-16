package java_study_03;
/*
 * hash码将对象的地址值转为整数输出
 * */
import java_study_01.AnimalDemo;

public class HashCodeDemo {
	public static void main(String[] args) {
		AnimalDemo ad = new AnimalDemo() {
			
			@Override
			public void sleep() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				
			}
		};
		System.out.println(ad.hashCode());//1784662007
	}
	
}
