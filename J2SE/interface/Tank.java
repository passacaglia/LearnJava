public class Tank extends Car implements Weapon {
	public static void main(String args[]) {
		Tank t = new Tank();
		t.fire();
	}
	public void fire() {
		System.out.println("Tank is firing...");
	}
}