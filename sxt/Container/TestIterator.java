/**
*Iterator�ӿڣ�����
**/

import java.util.*;

public class TestIterator {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add(new Name("f1", "l1"));
		c.add(new Name("f2", "l2"));
		c.add(new Name("f3", "l3"));
		
		Iterator i = c.iterator();//����c��iterator�������õ�ʵ����Iterator�ӿڵĶ��󣨸�������ָ���������
		while(i.hasNext()) {
			Name n = (Name)i.next();//next()�ķ���ֵ��Object���ͣ���Ҫת��Ϊ��Ӧ����(java1.4��Object)
			System.out.println(n.getFirstName() + " ");
		}
		
		//Iterator�����remove���� ���ڵ���������ɾ��Ԫ�ص�Ψһ�İ�ȫ���� | ����
		//������������remove����
		c.add(new Name("ff3", "ll3"));
		c.add(new Name("ff2", "ll2"));
		c.add(new Name("ff1", "ll1"));
		
		for (Iterator ite = c.iterator(); ite.hasNext(); ) {//�˴�forѭ��û�еڶ����ֺź�Ķ������ǾͲ�ִ��
			Name name  = (Name)ite.next();
			if (name.getFirstName().length() < 3) {
				ite.remove();
			}
		}
		
		System.out.println("After add & remove \n" + c);		
	}
}

class Name {
	private String firstName, lastName;
	Name(String firstName, String lastName) {
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
  
  public boolean equals(Object obj) {
  	if (obj instanceof Name) {
  		Name n = (Name)obj;
  		return (firstName.equals(n.firstName)) 
  				&& (lastName.equals(n.lastName));
  	}
  	
  	return super.equals(obj);
  }
  
  public int hashCode() {
  	return firstName.hashCode();
  }
}