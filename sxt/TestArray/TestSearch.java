public class TestSearch {
	public static void main(String args[]) {
		int a[] = {1, 4, 6, 8, 9, 10, 13, 16, 19, 22, 25, 36, 48, 49, 87};
		int num = 19;
		
		
		System.out.println(bSearch(a, num) + "th");
	}
	
	static int bSearch(int a[], int num) {
		int startPosition = 0;
		int endPosition = a.length-1;
		int p = ((startPosition + endPosition) / 2);
		
		while (startPosition <= endPosition) {
			if (num == a[p]) {
				return p;
			}
			if (num > a[p]) {
				startPosition = p+1;// = p , ok. just the speed.
			}
			if (num < a[p]) {
				endPosition = p-1;
			} 
			p = ((startPosition + endPosition) / 2);
		}
		
		return -1;
	}
}