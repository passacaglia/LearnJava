import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 6666);
		Thread.sleep(30000);
		OutputStream os = s.getOutputStream();//ȡ������ܵ��� 
		//| �ɼ���server��client���������ӣ����������ܵ������������server�������Ӧclient�������
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Hello, server!");
		dos.flush();
		
		
		dos.close();
		s.close();
	}
}