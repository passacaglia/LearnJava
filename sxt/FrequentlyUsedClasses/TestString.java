/**
*求出现的小写字母个数，大写？其他？
**/

public class TestString {
	public static void main(String args[]) {
		String s = "AaaaABBBBcc&^%asdfdCCOOkk99876 _haHA";
		
		int lowerCount = 0;
		int upperCount = 0;
		int otherCount = 0;
		
		//method 1
		/*
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				lowerCount ++;
			} else if (c >= 'A' && c <= 'Z') {
				upperCount ++;
			} else {
				otherCount ++;
			}
		}
		*/
		
		//method 2
		/*
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//不等于 -1 表示 有第一次出现了，也就是在其中；
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (lower.indexOf(c) != -1) {
				lowerCount ++;
			} else if (upper.indexOf(c) != -1) {
				upperCount ++;
			} else {
				otherCount ++;
			}
		}	
		*/
		
		//method 3
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLowerCase(c)) {
				lowerCount ++;
			} else if (Character.isUpperCase(c)) {
				upperCount ++;
			} else {
				otherCount ++;
			}
		}			
		
		System.out.println(s.length());
		System.out.print("lower letter count : " + lowerCount + " | upper letter count : " + upperCount + " | other count : " + otherCount);
	}
}