/**
*�ͻ�����˵��
*���ܶ���˵��Ҫ��Ȼ����������
*
***********/

import java.net.*;
import java.io.*;

public class TCPClient_SpeakFirst {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println("Connection to " + s.getInetAddress() + " #" + s.getPort() + " established.");
			
			//speak
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = null;

			
			//listen
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			/*
			*���ǡ�bye����ʱ�򣺶���д��
			*�ǡ�bye����ʱ��say goodbye��
			*/
			//���ǡ�bye����
			while(!(str=br.readLine()).equals("bye")) {
				dos.writeUTF(str);//���ﲻҪ����br.readLine()������server�˽��ղ�����
				dos.flush();				
				
				System.out.println(dis.readUTF());
			}
			
			//�ǡ�bye����
			System.out.println("bye-bye.");
			dos.writeUTF(s.getInetAddress() + " say bye-bye.");
			dos.flush();
			dos.close();
			s.close();
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}