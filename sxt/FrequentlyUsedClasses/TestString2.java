public class TestString2 {
	public static void main(String[] args) {
		String s = "sunjavahellojavahphahajava ejavaibmjavaoraclejavajavajavajavajavajava";
		
		
		String sToFind = "java";
		int count = 0;
		int index = -1;
		
		//找到一个"java"，把后面的后面的部分保留，赋给s；
		while ((index = s.indexOf(sToFind)) != -1) {
			s = s.substring(index+4, s.length());
			count ++;
		}
		
		System.out.println(count);

	}
}