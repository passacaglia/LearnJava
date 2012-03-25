/**
*·þÎñÆ÷¶Ë£¬ÏÈÌý¡£
*
*
*******/

import java.net.*;
import java.io.*;

public class TCPServer_ListenFirst {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("Server started...");
			
			while(true) {
				Socket s = ss.accept();
				System.out.println(s.getInetAddress() + " #" + s.getPort() + " : connected.");

				//listen
				InputStream is = s.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				
				
				//speak
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String str = null;
				
				while(!s.isClosed()) {
					System.out.println(dis.readUTF());

					dos.writeUTF(br.readLine());
					dos.flush();
				}
				
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}