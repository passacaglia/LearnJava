import java.util.*;

public class TestMap {
	public static void main(String[] args) {
		Map m1 = new HashMap();
		Map m2 = new TreeMap();
		//m1.put("one", new Integer(1));
		m1.put("one", 1);//��������д���Զ����	�ɶ���
		//m1.put("two", new Integer(2));
		m1.put("two", 2);
		//m1.put("three", new Integer(3));
		m1.put("three", 3);
		//m2.put("A", new Integer(1));
		m2.put("A", 1);
		//m2.put("B", new Integer(2));
		m2.put("B", 2);
		System.out.println("m1.size(): " + m1.size() + "		 " + "m2.size(): " + m2.size());
		System.out.println("m1.containsKey(\"one\"): " + m1.containsKey("one"));
		System.out.println("m2.containsValue(new Integer(1)): " + m2.containsValue(new Integer(1)));
		
		if (m1.containsValue("two")) {
			//int i = ((Integer)m1.get("two")).intValue();
			//m1.get("two")����Object����ǿ��ת����Integer
			//ע��((Integer)m1.get("two"))������Ҫ������
			
			int i = (Integer)m1.get("two");//��������д���Զ����	�ɻ�������
			
			System.out.println(i);
		} else {
			System.out.println("m1.containsValue(\"two\")? : No 			 do you mean ContainsKey");
		}
		
		Map m3 = new HashMap(m1);
		m3.putAll(m2);
		System.out.println(m3);
	}
}