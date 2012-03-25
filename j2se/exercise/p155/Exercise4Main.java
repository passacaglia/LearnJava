public class Exercise4Main extends Exercise4 {
	public static void main (String args[]) {
		Exercise4 q1 = new Exercise4();
		Exercise4Main q2 = new Exercise4Main();
		q1.method(1);
		q2.method(2);
	}
	
	public void method (int k) {
		System.out.println(20);
	}
}