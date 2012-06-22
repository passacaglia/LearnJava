public class Fighter extends Car implements Weapon {
	public static void main(String args[]) {
		Fighter f = new Fighter();
		f.fire();
	}
	
	public void fire() {
		System.out.println("Fighter is firing AIM-120 ...");
	}
}