package com.az;

public class TestReflection {

	/**
	 * When you run this program, please add the 
	 * VM arguments: -verbose:class .
	 */
	public static void main(String[] args) {
		//����Ҫ����
		new A();
		System.out.println("******Where am I ?******");
		new B();
		
		//static,һ�Ρ�dynamic,ÿ�Ρ�
		new C();
		new C();
		new D();
		new D();

	}

}

class A {
	
}

class B {
	
}

class C {
	//static, load one time.
	static {
		System.out.println("*******Hello, I'm C :) !*******");
	}
}

class D {
	//dynamic , load once the object is created.(�� ����)
	{
		System.out.println("*******Hello, I'm D :D !*******");
	}
}