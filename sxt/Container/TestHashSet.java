//Set�������ظ�������
//����
//�ϼ�
//ע��retainAll��addAll��ʹ�÷�����


import java.util.*;

public class TestHashSet {
	public static void main(String[] args) {
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s2.add("b");
		s2.add("c");
		s2.add("d");
		
		Set sr = new HashSet(s1);
		sr.retainAll(s2);

		Set su = new HashSet(s1);
		su.addAll(s2);	
		
		System.out.print(sr);	
		System.out.print(su);
	}
}