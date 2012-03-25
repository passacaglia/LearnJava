import java.util.*;

public class EnhancedFor {
	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 32, 7, 9};
		
		//int i
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		Collection c = new ArrayList();
		c.add(new String("str"));
		c.add(new String("str1"));
		c.add(new String("str2"));
		
		//Object o
		for (Object o : c) {
			System.out.print(o + " ");
		}		
	}
}