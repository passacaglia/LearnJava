public class Exercise6Main extends Exercise6 {
	public static void main (String args[]) {
		Exercise6 q1 = new Exercise6();
		Exercise6 q2 = new Exercise6Main();
		q1.method(1);
		((Exercise6Main)q2).method(2);
	}
	
	public void method (int k) {
		System.out.println(20);
	}
}