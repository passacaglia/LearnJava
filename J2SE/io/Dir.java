import java.io.*;
import java.util.Date;

public class Dir {
	private static int countDir = 0;
	private static int countFile = 0;
	private static long fileByte = 0;
	
	public static void main(String[] args) {
		File f = new File(System.getProperty("user.dir"));
		System.out.println("\nLast Modified" + "		" + "File Type" + "	" + "Size" + "	" + "File Name\n");
		File[] list = f.listFiles();
		for (int i=0; i<list.length; i++) {
			print(list[i]);
		}
		
		//Summary
			System.out.println("			" + countDir + " Dir<s>");
			System.out.println("			" + countFile + " File<s> 	" + fileByte + " byte<s>");
	}
	
	static void print(File f) {
		String date = dateConv(f.lastModified());
		
		if (f.isDirectory()) {
			countDir ++;
			System.out.print(date + "	" + "<DIR>" + "		" + "" + "	" + f.getName() + " \n");
		} else {
			countFile ++;
			fileByte += f.length();
			System.out.print(date + "	" + "<File>" + "		" + f.length() + "	" + f.getName() + " \n");
		}
	}
	
	static String dateConv(long l) {
		String d = (new Date(l)).toString();
		String[] s = d.split(" ");
		String[] sTime = s[3].split(":");

		return (s[5] + "/" + s[1] + "/" + s[2] + " " + sTime[0] + ":" + sTime[1]);
	}
}