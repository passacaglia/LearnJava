public class DateSort {
	public static void main(String args[]) {
		Date d[] = new Date[11];
		d[0] = new Date(2011,10,28);
		d[1] = new Date(2008,5,9);
		d[2] = new Date(2004,4,9);
		d[3] = new Date(2002,8,17);
		d[4] = new Date(2004,5,9);
		d[5] = new Date(2006,1,23);
		d[6] = new Date(2008,8,3);
		d[7] = new Date(2003,2,20);
		d[8] = new Date(2005,4,9);
		d[9] = new Date(2004,5,7);
		d[10] = new Date(2001,12,6);
		
		print(d);
		selectionSort(d);
		print(d);
		
	}
	
	private static void bubbleSort(Date a[]) {
		
		Date temp;
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a.length-1; j++) {
				if (compare(a[j],a[j+1])) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	private static void selectionSort(Date a[]) {
		
		Date temp;
		int k;
		
		for (int i=0; i<a.length; i++) {
			k = i;
			for (int j=k+1; j<a.length; j++) {
				//select the smaller one;
				if (compare(a[k],a[j])) {
					k = j;
				}
			}
			
			if (i != k) {
				temp = a[i];
				a[i] = a[k];
				a[k] = temp;
			}
		}
	}
	
	private static boolean compare(Date a, Date b) {
		
		if (a.year > b.year) {
			return true;
		} 
		else if (a.year == b.year) {
			if (a.month > b.month) {
				return true;
			}
			else if (a.month == b.month) {
				if (a.day > b.day) {
					return true;
				}
				else if (a.day == b.day) {
					return false;
				}
			} 
		}
		
		return false;
		
		/**
		*大于、小于、等于
		*大于时，返回true。不是的话，还有两种情况，小于&等于。
		*小于时，返回false。不是的话，就是等于咯。等于的话就再去判断month。
		**/
		/**
		*return year > date.year ? 1
    *       : year < date.year ? -1
    *       : month > date.month ? 1
    *       : month < date.month ? -1
    *       : day > date.day ? 1
    *       : day < date.day ? -1 : 0;
		**/
		
	}
	
	private static void print(Date a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
}

class Date {
	
	int year, month, day;
	
	Date(int year,int month,int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString() {
		return (year + ", " + month + ", " + day);
	}
}