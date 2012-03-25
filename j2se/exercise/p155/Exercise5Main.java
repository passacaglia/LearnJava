public class Exercise5Main extends Exercise5 {
	public static void main (String args[]) {
		Exercise5 q1 = new Exercise5();
		Exercise5 q2 = new Exercise5Main();
		q1.method(1);
		q2.method(2);
	}
	
	public void method (int k) {
		System.out.println(20);
	}
}