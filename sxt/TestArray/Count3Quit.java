public class Count3Quit {
	public static void main(String args[]) {
		boolean arr[] = new boolean[500];//"a[index] = false;"
		//int a[] = new int[500]; If use this one,try "a[index] = 0;"
		for (int i=0; i<arr.length; i++) {
			arr[i] = true;
			//a[i] = i+1;
		}
		
		int leftCount = arr.length;
		int count = 0; //say 1, 2, 3;  means,once meet a people,count ++
		int index = 0;
		
		while (leftCount > 1) {
			if (arr[index] == true) {
				count ++;
				if (count == 3) {
					count = 0;
					arr[index] = false;
					leftCount --;
				}
			}

			index ++;
			if (index == arr.length) {
				index = 0;				
			}
		}
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == true) {
				System.out.println("The left people is the " + (i+1) + "th one.");
			}
		}
		
	}
}