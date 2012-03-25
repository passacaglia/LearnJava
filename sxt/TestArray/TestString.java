public class TestString {
	public static void main(String args[]) {
		String s[][] = new String[3][];
		s[0] = new String[2];
		s[1] = new String[3];
		s[2] = new String[1];
		
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<s[i].length; j++) {
				s[i][j] = ("My position is " + i + " , " + j);
				System.out.println(s[i][j]);
			}
		}
		
		
	}
}