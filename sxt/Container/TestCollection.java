import java.util.*;
import java.util.ArrayList;

public class TestCollection {
	public static void main(String[] args) {
		Collection c = new ArrayList();//���Է��벻ͬ���͵Ķ���
		c.add("Hello");
		c.add(new Name("f1","l1"));
		c.add(new Integer(100));
		System.out.println(c.size());
		System.out.println(c);//�ڲ���ʵ�֣� ����c��toString��������ӡ��"["   "]" ��    Ȼ�����ε���c�ڴ洢�Ķ����toString������
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