public class Person {
	String name;
	String location;
	
	Person(String n) {
		this.name = n;
		this.location = "beijing";
	}
	
	Person(String n, String l) {
		this.name = n;
		this.location = l;
	}
	
	public String info() {
		return "\nname: " + this.name + " location: " + this.location;
	}
	
	public String toString() {
		return ("Hello, I'm a teacher : " + this.name);
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}
		else if (obj instanceof Student) {
			Person p = (Person)obj;
			if (p.name == this.name && p.location == this.location) {
				return true;
			}
		}

			return false;

	}
}

