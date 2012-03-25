public class TestEquals {
	public static void main(String args[]) {
		Cat c1 = new Cat("White", 15, 50);
		Cat c2 = new Cat("White", 15, 5);
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1.equals(s2));
	}
}

class Cat {
	
	String color;
	int height, weight;
	
	public Cat(String color, int height, int weight) {
		this.color = color;
		this.height = height;
		this.weight = weight;
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}
		else if (obj instanceof Cat) {
				Cat c = (Cat)obj;
				if (c.color == this.color && c.height == this.height && c.weight == this.weight) {
					return true;
				}
		}
		
		//obj != null & obj is not a Cat.
		return false;
	}
}