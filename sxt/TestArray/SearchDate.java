public class SearchDate {
	public static void main(String args[]) {
		Date[] d = new Date[5];
		d[0] = new Date(2005, 3, 12);
		d[1] = new Date(2018, 6, 2);
		d[2] = new Date(2001, 9, 30);
		d[3] = new Date(2003, 8, 15);
		d[4] = new Date(2008, 12, 31);
		
		Date.dateSort(d);
		for (int i=0; i<d.length; i++) {
			System.out.println(d[i]);
		}
		
		System.out.println(Date.searchDate(d, d[3]));
	}
	
}

class Date {
	int year, month, day;
	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int compare2(Date date) {
    return year > date.year ? 1
           : year < date.year ? -1
           : month > date.month ? 1
           : month < date.month ? -1
           : day > date.day ? 1
           : day < date.day ? -1 : 0;
  }
	
	static void dateSort(Date[] d) {
		Date temp;
		for (int i=0; i<d.length; i++) {
			for (int j=0; j<d.length-i-1; j++) {
				if (compare(d[j], d[j+1])) {
					temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
			}
		}
	}
	
	static boolean compare(Date d1, Date d2) {
		return d1.year > d2.year ? true 
					 : d1.year < d2.year ? false 
					 : d1.month > d2.month ? true 
					 : d1.month < d2.month ? false
					 : d1.day > d2.day ? true
					 : d1.day < d2.day ? false : false;
	}
	

	
	static int searchDate(Date[] d, Date day) {
		int startPosition = 0;
		int endPosition = d.length;
		int m = (startPosition + endPosition) / 2;
		
		while (startPosition <= endPosition) {
			if (day.compare2(d[m]) == 0) {
				return m;
			} else if (day.compare2(d[m]) == 1) {
				startPosition = m+1;
			} else if (day.compare2(d[m]) == -1) {
				endPosition = m-1;
			}
			m = (startPosition + endPosition) / 2;
		}
		
		/*
		while (startPosition <= endPosition) {
			if (day.year == d[m].year) {
				if (day.month == d[m].month) {
					if (day.day == d[m].day) {
						return m;
					} else if (day.day > d[m].day) {
						startPosition = m+1;
					} else if (day.day < d[m].day) {
						endPosition = m-1;
					}
					
					m = (startPosition + endPosition) / 2;
					
				} else if (day.month > d[m].month) {
					startPosition = m+1;
				} else if (day.month < d[m].month) {
					endPosition = m-1;
				}
				
				m = (startPosition + endPosition) / 2;
				
			} else if (day.year > d[m].year) {
				startPosition = m+1;
			} else if (day.year < d[m].year) {
				endPosition = m-1;
			}
			
			m = (startPosition + endPosition) / 2;
		}
		*/
		
		return -1;
		
	}
	
	public String toString() {
		return (year + " , " + month + " , " + day);
	}
}