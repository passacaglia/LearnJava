import java.util.*;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		m1.put("m1", 1);
		m1.put("m2", 1);
		m1.put("m1", 2);
		m1.put("m2", 2);
		System.out.println(m1);
	}
}