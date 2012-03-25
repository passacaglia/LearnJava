/**
*客户端先说。
*不能都先说，要不然都阻塞死。
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
			*不是“bye”的时候：读、写。
			*是“bye”的时候：say goodbye。
			*/
			//不是“bye”：
			while(!(str=br.readLine()).equals("bye")) {
				dos.writeUTF(str);//这里不要在用br.readLine()，否则server端接收不到。
				dos.flush();				
				
				System.out.println(dis.readUTF());
			}
			
			//是“bye”：
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