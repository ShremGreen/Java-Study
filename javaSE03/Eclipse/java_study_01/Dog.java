package java_study_01;

import java_study_02.Jump;

public class Dog extends AnimalDemo implements Jump {

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("dog jumping");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("dog eating");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("dog sleeping");
	}

}
