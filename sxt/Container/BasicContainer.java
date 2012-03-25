import java.util.*;

public class BasicContainer {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("Hello");
		c.add(new Integer(100));
		c.add(new Name("f1","l1"));
		c.remove("Hello");
		c.remove(new Integer(100));
		System.out.println(c.remove(new Name("f1","l1")));
		System.out.println(c);
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