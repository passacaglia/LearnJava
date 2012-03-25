
import java.io.*;
import java.net.*;


public class TestHTTP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("127.0.0.1", 80);
			
			//����
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			pw.println("GET / HTTP/1.1");//GET  /����ĵ�ַ��  HTTP/1.1
			pw.println("HOST: localhost");//��Ҫ����s��IPַ��//һ��IP�¿��ܹ�����������
			pw.println("Content-type: text/html");
			pw.println();//���У���ʾ������Ķ����Ѿ�˵�ꡣ
			pw.flush();
			
			//��
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = "";
			while ((str=br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();
			pw.close();
			s.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}















































































