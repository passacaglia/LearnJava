public class TestString2 {
	public static void main(String[] args) {
		String s = "sunjavahellojavahphahajava ejavaibmjavaoraclejavajavajavajavajavajava";
		
		
		String sToFind = "java";
		int count = 0;
		int index = -1;
		
		//�ҵ�һ��"java"���Ѻ���ĺ���Ĳ��ֱ���������s��
		while ((index = s.indexOf(sToFind)) != -1) {
			s = s.substring(index+4, s.length());
			count ++;
		}
		
		System.out.println(count);

	}
}