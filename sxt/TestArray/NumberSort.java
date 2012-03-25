public class NumberSort {
	 
	/**
	*读进9个数；
	*构建成一个int型数组；
	*顺序排好；
	**/
	public static void main(String args[]) {
		
		int a[] = new int[args.length];
		
		if (args.length == 0) {
			System.out.println("Usage: Please input some numbers in command line parameters. 0");
			System.exit(-1);
		}
		
		try {
			for ( int i=0; i<args.length; i++ ) {
				a[i] = Integer.parseInt(args[i]);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Usage: Please input some numbers in command line parameters! err");
			nfe.printStackTrace();
			System.exit(-1);
		}
		
		print(a);
		bubbleSort(a);
		print(a);
		
		
	}
		

	
	private static void selectionSort(int a[]) {
		int k, temp;
		
		//找到后面最小的数,并且交换到前面
		for (int i=0; i<a.length; i++) {
			k = i;
			for (int j=k+1; j<a.length; j++) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			
			if (k != i) {
				temp = a[i];
				a[i] = a[k];
				a[k] = temp;
			}
		}
	}

	private static void bubbleSort(int a[]) {
		int temp;
		for (int i=0; i<a.length-1; i++) {
			for (int j=0; j<a.length-i-1; j++) {
				if (a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	
	
	private static void print(int a[]) {
		for ( int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
	}
}