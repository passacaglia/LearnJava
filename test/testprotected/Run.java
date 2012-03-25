package testprotected;
import testprotected.pac.Pack;

public class Run {
	public static void main(String agrs[]) {
		TestProtected t1 = new TestProtected();
		TestProtected t2 = new Pack();
		Pack t3 = new Pack();
		
		t1.method();
		t2.method();
		t3.method();
		System.out.println(t1.i);
		System.out.println(t2.i);
		System.out.println(t3.i);
	}
}