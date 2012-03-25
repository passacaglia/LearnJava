/**
*�������ݺ������Ļ����ʾһ�Ρ�ͬʱ��������ݼ�¼��log�ļ��У�ʹ�õ���PrintWriter�����ṩ�˸���Ĵ�ӡ���������ҳ���ʱ���ᱨ�쳣����
*
*s.equalsIgnoreCase("exit")���Դ�Сд
*��ȡ���ڵķ���
**/

import java.io.*;
import java.util.Date;

public class TestPrintWriter {
	public static void main(String[] args) {
		//read
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//write
		FileWriter  fw = null;
		String s = null;
		
		try {
			fw = new FileWriter("./TestPrintWriter.log", true);
			PrintWriter log = new PrintWriter(fw);
			
			while((s=br.readLine()) != null) {
					if (s.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println(s.toUpperCase());
						log.println(s.toUpperCase());
					}
			}
			
			log.println("- - -" + new Date() + "- - -\n");
			log.close();
			br.close();			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}  