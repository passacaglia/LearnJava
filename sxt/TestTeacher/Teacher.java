class Teacher extends Person {
	private String captial;
	
	Teacher(String n, String c) {
		this(n,"beijing",c);
	}
	
	Teacher(String n, String l, String c) {
		super(n,l);
		this.captial = c;
	}
	
	public String info() {
		return super.info() + " captial:" + captial;	
	}
}