//Auto-boxing & unboxing & Generic

import java.util.*;

public class TestMapGeneric {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("one", 1);
		m.put("two", 2);
		m.put("three", 3);
		
		System.out.println(m);
		System.out.println("m.size(): " + m.size());
		System.out.println("m.get(\"two\"): " + m.get("two"));
		
		if (m.containsKey("three")) {
			/*
			*get的返回值类型是	key-"three"对应的value	的类型。get方法，返回值是value
			*
			*此处	自动打包和解包& 泛型
			*泛型： 已经定义	放入的是Integer，不用强制转换了， "(Integer)"不用写了
			*自动打包和解包： 	这里是自动解包，".intValue()不用写了"
			*/
			int i = m.get("three");
			System.out.println("three " + i);
		}
	}
}