//You should add a ÃüÁîĞĞ²ÎÊı to run the program correctly.

public class ExternalProgram {
	public static void main(String args[]) {
		int a[] = new int[7];
		for (int i=0; i<a.length; i++) {
			a[i] = 98+i;
			System.out.println(a[i]);
		}
		
		int i = Integer.parseInt(args[0]);
		
		System.exit(i);
	}
}