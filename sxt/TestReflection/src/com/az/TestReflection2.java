package com.az;

import java.lang.reflect.Method;

public class TestReflection2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String str = "com.az.T";
		Class c = Class.forName(str);
		Object o = c.newInstance();
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			if (m.getName().equals("m1")) {
				m.invoke(o);
			}
			
			if (m.getName().equals("m2")) {
				m.invoke(o, 1);
				for (Class paramType : m.getParameterTypes()) {
					System.out.println(paramType.getName());
				}
			}
			
			if (m.getName().equals("getS")) {
				Class returnType = m.getReturnType();
				System.out.println(returnType.getName());
				
			}
		}
	}

}


class T {
	
	static {
		System.out.println("T loaded!");
	}
	
	int i;
	String string;
	
	public T() {
		print("T constructed!");
	}
	
	public void m1() {
		print("m1 invoked!");
	}
	
	public void m2(int i) {
		this.i = i;
	}
	
	public String getS() {
		return string;
	}
	
	public void print(String s) {
		System.out.println(s);
	}
}






















