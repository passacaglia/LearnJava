public class TestStringBuffer2 {
	public static void main (String args[]) {
		StringBuffer sb = new StringBuffer("Hello");
		StringBuffer sb2 = sb.append(" Java");
		System.out.println("sb : " + sb);
		System.out.println("sb2 : " + sb2);
		System.out.println("sb.equals(sb2) ? " + (sb.equals(sb2)));
		System.out.println("sb == sb2 ? " + (sb == sb2));
	} 
}