/**
*Iterator接口，遍历
**/

import java.util.*;

public class TestIterator {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add(new Name("f1", "l1"));
		c.add(new Name("f2", "l2"));
		c.add(new Name("f3", "l3"));
		
		Iterator i = c.iterator();//调用c的iterator方法，拿到实现了Iterator接口的对象（父类引用指向子类对象）
		while(i.hasNext()) {
			Name n = (Name)i.next();//next()的返回值是Object类型，需要转换为相应类型(java1.4是Object)
			System.out.println(n.getFirstName() + " ");
		}
		
		//Iterator对象的remove方法 是在迭代过程中删除元素的唯一的安全方法 | 锁定
		//不能用容器的remove方法
		c.add(new Name("ff3", "ll3"));
		c.add(new Name("ff2", "ll2"));
		c.add(new Name("ff1", "ll1"));
		
		for (Iterator ite = c.iterator(); ite.hasNext(); ) {//此处for循环没有第二个分号后的东东，那就不执行
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