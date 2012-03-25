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
			*get�ķ���ֵ������	key-"three"��Ӧ��value	�����͡�get����������ֵ��value
			*
			*�˴�	�Զ�����ͽ��& ����
			*���ͣ� �Ѿ�����	�������Integer������ǿ��ת���ˣ� "(Integer)"����д��
			*�Զ�����ͽ���� 	�������Զ������".intValue()����д��"
			*/
			int i = m.get("three");
			System.out.println("three " + i);
		}
	}
}