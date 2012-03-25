/**
*��������в���	���ֵ�Ƶ��
*��ͼ�������
**/

import java.util.*;

/*
public class TestArgsWords {
	
	private static final Integer ONE = new Integer(1);
	
	public static void main(String[] args) {
		
		Map m = new HashMap();
		
		for (int i=0; i<args.length; i++) {
			Integer frequence = (Integer)m.get(args[i]);//Ƶ��
			m.put(args[i], (frequence == null ? ONE : (new Integer(frequence.intValue()) + 1)));//�����в����ͳ���Ƶ�ʳɶԴ浽m�
		}
		
		System.out.println(m.size() + " distinct words detected .");
		System.out.println(m);
	}
	
}
*/

//Auto-boxing & unboxing
/*
public class TestArgsWords {
	
	private static final int ONE = 1;
	
	public static void main(String[] args) {
		Map m = new HashMap();
		for (int i=0; i<args.length; i++) {
			int frequence = ((Integer)m.get(args[i]) == null ? 0 : ((Integer)m.get(args[i])).intValue());
			m.put(args[i], frequence == 0 ? ONE : (frequence + 1));
		}
		
		System.out.println(m.size() + " distinct words detected .");
		System.out.println(m);
	}
}
*/

//Auto-boxing & unboxing & Generic
public class TestArgsWords {
	
	private static final int ONE = 1;
	
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i=0; i<args.length; i++) {
			if (!m.containsKey(args[i])) {
				m.put(args[i], ONE);
			} else {
				int freq = m.get(args[i]);
				m.put(args[i], freq + 1);
			}
		}
		
		System.out.println(m.size() + " distinct words detected .");
		System.out.println(m);
	}
}