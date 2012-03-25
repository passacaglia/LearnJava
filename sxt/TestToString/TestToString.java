public class TestToString {
	public static void main(String args[]) {
		Dog d = new Dog();
		System.out.println("\nd : " + d);
	}
}

class Dog {
	public String toString() {
		return "I am a cool dog!";
	}
}