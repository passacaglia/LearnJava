import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 6666);
		Thread.sleep(30000);
		OutputStream os = s.getOutputStream();//取得输出管道。 
		//| 可见：server和client建立的连接，包含两条管道。输入输出。server的输入对应client的输出。
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Hello, server!");
		dos.flush();
		
		
		dos.close();
		s.close();
	}
}