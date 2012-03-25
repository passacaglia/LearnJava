import java.util.*;
import java.util.ArrayList;

public class TestCollection {
	public static void main(String[] args) {
		Collection c = new ArrayList();//可以放入不同类型的对象
		c.add("Hello");
		c.add(new Name("f1","l1"));
		c.add(new Integer(100));
		System.out.println(c.size());
		System.out.println(c);//内部的实现： 调用c的toString方法，打印出"["   "]" 。    然后依次调用c内存储的对象的toString方法。
	}
}

class Name {
	private String firstName, lastName;
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
}