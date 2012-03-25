/**
*add、set、remove
*add：添加到index=3【第四个位置上】.	则原本index=3及其后面的往后移动。
*set：这个set有返回值。返回值是原来位置上的 元素。
*
*List 常用算法在java.util.Collections类里面
*shuffle//随机排列
*reverse//逆序
*sort//排序,将 当前 集合元素逆序
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
		
		Collections.shuffle(l2);//随机排列
		System.out.println(l2 + " shuffle");
		
		Collections.reverse(l2);//逆序，把现在的这个顺序逆过来
		System.out.println(l2 + " reverse");
		
		Collections.sort(l2);//排序
		System.out.println(l2 + " sort");
		
		System.out.println(Collections.binarySearch(l2, "aa6"));//折半查找
		System.out.println(Collections.binarySearch(l2, "b6"));
	}
}