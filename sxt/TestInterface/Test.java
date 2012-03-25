public class Test {
	public static void main(String args[]) {
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		Farmer f1 = new Farmer();
		Farmer f2 = new Farmer();
		Leader l1 = new Leader();
		Leader l2 = new Leader();
		
		System.out.println(w1.Feeding());
		System.out.println(w2.Playing());
	}
}

class Worker implements PetTakeCare {
	public String Feeding() {
		return (this.getClass().getSimpleName() + " is feeding his pet.");
	}
	public String Playing() {
		return (this.getClass().getName() + " is playing with his pet.");
	}
}

class Farmer implements PetTakeCare {
	public String Feeding() {
		return " is feeding his pet.";
	}
	public String Playing() {
		return " is playing with his pet.";
	}
}

class Leader implements PetTakeCare {
	public String Feeding() {
		return "is feeding his pet.";
	}
	public String Playing() {
		return " is playing with his pet.";
	}
}