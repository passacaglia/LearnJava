import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HelloRE {

	public static void main(String[] args) {
		//����ʶ������ʽ�ĸ���
/*		System.out.println("abc".matches("..."));
		print("abc823150384750aupqert".replaceAll("\\d", "-"));
		
		//1.
		Pattern pt = Pattern.compile("[a-z]{3}"); //�Ȱ�����pattern�����£�����ִ������Ч�ʸߡ�
		Matcher mc = pt.matcher("fgh");
		print(mc.matches());
		
		//2.   "1." �൱�ڡ���������������������  ���������Ч�ʸߡ�
		print("fgh".matches("[a-z]{3}"));
		
*/		
		//��ʶ .  *  +  ?
/*		print("a".matches("."));
		print("aa".matches("aa"));
		print("aaaa".matches("a*"));
		print("aaaa".matches("a+"));
		print("aaaa".matches("a?"));
		print("".matches("a*"));// zero length
		print("".matches("a?"));
		print("a".matches("a?"));
		print("46598".matches("\\d{3,100}"));
		print("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		print("192".matches("[0-2][0-9][0-9]"));
*/
		
		//��Χ
/*		print("a".matches("[abc]"));//ȡabc�е�ĳ�����ɣ�һ�������Ŵ���һ���ַ�
		print("a".matches("[^abc]"));//��ȥabc
		print("A".matches("[a-zA-Z]"));//ȡСдa-z���ߴ�д��A-Z
		print("A".matches("[a-z]|[A-Z]"));//ͬ��
		print("A".matches("[a-z[A-Z]]"));
		print("R".matches("[A-Z && [RFG]]"));
*/
		
		//��ʶ\s \w \d 
/*		print(" \n\r\t".matches("\\s{4}"));
		print(" ".matches("\\S"));
		print("a_8".matches("\\w{3}"));
		print("abc888&^%".matches("[a-z]{1,3}\\d+[&^%]+"));
		print("\\".matches("\\\\"));//��java��  ��������ʽ   ƥ��һ��  "\"�� ���ĸ�"\\\\"
*/
		
		//�߽紦��
/*		print("hello sir".matches("^h.*"));
		print("hello sir".matches(".*ir$"));
		//�հ���
		print(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
		//test
		print("aaa 8888c".matches(".*\\d{4}."));
		print("aaa 8888c".matches(".*\\b\\d{4}."));
		print("aaa8888c".matches(".*\\d{4}."));
		print("aaa8888c".matches(".*\\b\\d{4}."));
*/		
		//email
		//print("abasdfwertas@asodfjowe.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
		
		//matches, find, lookingAt
/*		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-23456-1234-00";
		Matcher m = p.matcher(s);
		print(m.matches());  //ƥ�������ַ���
		m.reset();
		
		print(m.find());  //���Ӵ�      |    ��matches()ͬʱʹ�õ�ʱ����Ӱ�졣��m.reset()�����ַ�����
		print(m.find());  //���ҵ��Ӵ��Ļ����ſ���   ������� ��ʼλ�á�
		print(m.start() + "--");   //�ҵ���ƥ���ַ�����   ��ʼλ�á������㿪ʼ��
		print(m.end());  //�ҵ���ƥ���ַ�����   ���һ���ַ�     �ĺ�һ��λ�á�
		print(m.find());
		print(m.find());
		
		print(m.lookingAt());  //ÿ�ζ��� ��ͷ��ʼ��
		print(m.lookingAt());
		print(m.lookingAt());
		print(m.lookingAt());
*/
		
		//replacement
/*		Pattern p = Pattern.compile("java");
		Matcher m = p.matcher("java Java JAVA jAvA IloveJavA jAVASource tail");
		while(m.find()) {
			print(m.group());//����������ʽ������һ�� �顣
		}
*/		
/*		//���滻�ɴ�д�ġ�
  		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVA jAvA IloveJavA jAVASource tail");
		print(m.replaceAll("JAVA"));
*/
/*		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVA jAvA IloveJavA jAVASource tail");
		StringBuffer buf = new StringBuffer();
		int i = 0;
		while(m.find()) {
			i++;
			if (i%2 == 0) {
				m.appendReplacement(buf, "java");//����λ��java�����ĳ�Сд�ġ�
			} else {
				m.appendReplacement(buf, "JAVA");//ż��λ�ϵģ����ĳɴ�д�ġ�
			}
		}
		m.appendTail(buf);//don't forget this
		print(buf);
*/
		
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
		String s = "123aa-13536bb-890cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			//print(m.group());
			print(m.group(1));//��һ��С���ţ��ǵ�һ�顣//ֻ��ӡ����
			//print(m.group(2));//letters only
		}

		
		
		
		
		
		
		
		
	}
	
	public static void print (Object o) {
		System.out.println(o);
	}

}























