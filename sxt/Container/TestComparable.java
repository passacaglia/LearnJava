import java.util.*;

public class TestComparable {
	public static void main(String[] args) {
		List l1 = new LinkedList();
		l1.add(new Name("Tom", "Lee"));
		l1.add(new Name("Jack", "M"));
		l1.add(new Name("Steven", "X"));
		l1.add(new Name("Lucy", "M"));
		System.out.println(l1);
		
		Collections.sort(l1);
		System.out.println(l1);
	}
}

class Name implements Comparable {
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
  
  public int compareTo(Object o) {
  	Name name = (Name)o;
  	
  	//这里又调用了String的compareTo方法
  	int lastNameCompare = this.lastName.compareTo(name.lastName);
  	
  	//不等于0？
  	//是：返回lastNameCompare的值。如果大于0，表示比传入的Name大。
  	//否：比较firstName。firstName比较结果如果大于0，表示  比传入的Name大。
  	return (lastNameCompare != 0 ? lastNameCompare : this.firstName.compareTo(name.firstName));
  	}
}
