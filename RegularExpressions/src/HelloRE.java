import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HelloRE {

	public static void main(String[] args) {
		//简单认识正则表达式的概念
/*		System.out.println("abc".matches("..."));
		print("abc823150384750aupqert".replaceAll("\\d", "-"));
		
		//1.
		Pattern pt = Pattern.compile("[a-z]{3}"); //先把这种pattern编译下，后面执行起来效率高。
		Matcher mc = pt.matcher("fgh");
		print(mc.matches());
		
		//2.   "1." 相当于　下面这个，但是下面这个  不如上面的效率高。
		print("fgh".matches("[a-z]{3}"));
		
*/		
		//认识 .  *  +  ?
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
		
		//范围
/*		print("a".matches("[abc]"));//取abc中的某个即可，一个中括号代表一个字符
		print("a".matches("[^abc]"));//除去abc
		print("A".matches("[a-zA-Z]"));//取小写a-z或者大写的A-Z
		print("A".matches("[a-z]|[A-Z]"));//同上
		print("A".matches("[a-z[A-Z]]"));
		print("R".matches("[A-Z && [RFG]]"));
*/
		
		//认识\s \w \d 
/*		print(" \n\r\t".matches("\\s{4}"));
		print(" ".matches("\\S"));
		print("a_8".matches("\\w{3}"));
		print("abc888&^%".matches("[a-z]{1,3}\\d+[&^%]+"));
		print("\\".matches("\\\\"));//在java里  用正则表达式   匹配一个  "\"， 用四个"\\\\"
*/
		
		//边界处理
/*		print("hello sir".matches("^h.*"));
		print("hello sir".matches(".*ir$"));
		//空白行
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
		print(m.matches());  //匹配整个字符串
		m.reset();
		
		print(m.find());  //找子串      |    与matches()同时使用的时候，有影响。用m.reset()重置字符串。
		print(m.find());  //能找到子串的话，才可以   输出它的 起始位置。
		print(m.start() + "--");   //找到的匹配字符串的   起始位置。（从零开始）
		print(m.end());  //找到的匹配字符串的   最后一个字符     的后一个位置。
		print(m.find());
		print(m.find());
		
		print(m.lookingAt());  //每次都是 从头开始找
		print(m.lookingAt());
		print(m.lookingAt());
		print(m.lookingAt());
*/
		
		//replacement
/*		Pattern p = Pattern.compile("java");
		Matcher m = p.matcher("java Java JAVA jAvA IloveJavA jAVASource tail");
		while(m.find()) {
			print(m.group());//整个正则表达式看成是一个 组。
		}
*/		
/*		//都替换成大写的。
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
				m.appendReplacement(buf, "java");//单数位的java，都改成小写的。
			} else {
				m.appendReplacement(buf, "JAVA");//偶数位上的，都改成大写的。
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
			print(m.group(1));//第一个小括号，是第一组。//只打印数字
			//print(m.group(2));//letters only
		}

		
		
		
		
		
		
		
		
	}
	
	public static void print (Object o) {
		System.out.println(o);
	}

}























