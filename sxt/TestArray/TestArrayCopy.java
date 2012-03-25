public class TestArrayCopy {
	public static void main(String args[]) {
		String[] s = {"IBM", "MicroSoft", "Oracle", "Apple", "Google"};
		String[] sBak = new String[5];
		
		System.arraycopy(s, 0, sBak, 0, sBak.length);
		for (int i=0; i<sBak.length; i++) {
			System.out.print(sBak[i] + " ");
		}
		
		System.out.println();
		
		//[][]
		int[][] a = {{3, 4}, {2, 5, 7}, {8, 2, 5}};
		int[][] aBak = new int[3][];
		System.arraycopy(a, 0, aBak, 0, a.length);
		
		aBak[2][2] = 10000000;
		
		for (int i=0; i<aBak.length; i++) {
			for (int j=0; j<aBak[i].length; j++) {
				System.out.print(aBak[i][j] + " ");
			}
		}
	}
}