/**
*���� ������
*Be careful.
*�ո�Ҳ��String
*Line 10, 13.   s2 should be a [][].  not []  ||| ��������Ҳ����
*Line 20, NullPointerException.ʹ��d[i][j]ǰע���Ѿ����ɶ��������á�
**/

public class ArrayParser {
	public static void main(String[] args) {
		String str = "1,2;3,4,5;6,7,8";
		
		//method 1
		/*
		String[] s1 = str.split(";");
		String[][] s2 = new String[s1.length][];
		
		//split
		for (int i=0; i<s1.length; i++) {
				s2[i] = s1[i].split(",");
		}
		
		Double[][] d = new Double[s2.length][];
		
		//parse
		for (int i=0; i<s2.length; i++) {
			d[i] = new Double[s2[i].length];
			for (int j=0; j<s2[i].length; j++) {
				d[i][j] = Double.parseDouble(s2[i][j]);
				System.out.println("d[" + i + "][" + j + "] = " + d[i][j]);
			}
		}
		*/
		
		//method 2
		String[] sFirst = str.split(";");
		String[] sSecond;
		Double[][] d;
		
		for (int i=0; i<sFirst.length; i++) {
			sSecond = sFirst[i].split(",");
			d[i] = new Double[sSecond.length][];//������new������ ������d�Ƕ�ά���顣d[i]ָ�����d[i][],�ʺ��滹�и�[]��
			for (int j=0; j<sFirst[i].length(); j++) {//here sFirst[i]��String�͵ģ��������顣������()��
				d[i][j] = Double.parseDouble(sSecond[j]);
				System.out.println("d[" + i + "][" + j + "] = " + d[i][j]);
			}
		}
	}
}