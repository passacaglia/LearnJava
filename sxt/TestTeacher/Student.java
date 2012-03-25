class Student extends Person {
	private String school;
	
	Student(String n, String l) {
		this(n,"beijing",l);
	}
	
	Student(String n, String l, String s) {
		super(n,l);
		this.school = s;
	}
	
	public String info() {
		return super.info() + " school: " + this.school;
	}
	
	public String toString() {
		return "Hey, I'm a student.";
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		else if (obj instanceof Student) {
			Student s = (Student)obj;
			if (s.name == this.name && s.location == this.location) {
				return true;
			}
		}

			return false;

	}
}