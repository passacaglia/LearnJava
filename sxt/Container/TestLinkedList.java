/**
*add��set��remove
*add����ӵ�index=3�����ĸ�λ���ϡ�.	��ԭ��index=3�������������ƶ���
*set�����set�з���ֵ������ֵ��ԭ��λ���ϵ� Ԫ�ء�
*
*List �����㷨��java.util.Collections������
*shuffle//�������
*reverse//����
*sort//����,�� ��ǰ ����Ԫ������
**/

import java.util.*;

public class TestLinkedList {
	public static void main(String[] args) {
		List list = new LinkedList();
		for (int i=0; i<=5; i++) {
			list.add("a" + i);
		}
		System.out.println(list);
		list.add(3, "a100");
		System.out.println(list);
		list.add(4,list.set(3,"alpha"));
		System.out.println(list);
		
		System.out.println((String)list.get(3));
		System.out.println(list.indexOf("alpha"));
		
		list.remove(list.indexOf("alpha"));
		System.out.println(list);
		
		System.out.println("****************************");
		System.out.println("***java.util.Collections****");
		
		List l2 = new LinkedList();
		for (int i=0; i<=9; i++) {
			l2.add("b" + i);
		}
		System.out.println(l2 + " l2");
		
		Collections.shuffle(l2);//�������
		System.out.println(l2 + " shuffle");
		
		Collections.reverse(l2);//���򣬰����ڵ����˳�������
		System.out.println(l2 + " reverse");
		
		Collections.sort(l2);//����
		System.out.println(l2 + " sort");
		
		System.out.println(Collections.binarySearch(l2, "aa6"));//�۰����
		System.out.println(Collections.binarySearch(l2, "b6"));
	}
}