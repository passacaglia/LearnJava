public class Exercise10Main extends Exercise10 {
	public static void main (String args[]) {
		Exercise10 q1 = new Exercise10();
		Exercise10Main q2 = new Exercise10Main();
		q1.method(10);
		q2.method(20);
	}
	
	public void method(int i) {
		System.out.println(i);
	}
}