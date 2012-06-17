package com.az;

public class TestReflection {

	/**
	 * When you run this program, please add the 
	 * VM arguments: -verbose:class .
	 */
	public static void main(String[] args) {
		//按需要加载
		new A();
		System.out.println("******Where am I ?******");
		new B();
		
		//static,一次。dynamic,每次。
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
	//dynamic , load once the object is created.(用 的少)
	{
		System.out.println("*******Hello, I'm D :D !*******");
	}
}