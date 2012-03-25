
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
			
			//请求
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			pw.println("GET / HTTP/1.1");//GET  /请求的地址。  HTTP/1.1
			pw.println("HOST: localhost");//主要依靠s的IP址。//一个IP下可能管理多个域名。
			pw.println("Content-type: text/html");
			pw.println();//空行，表示：请求的东西已经说完。
			pw.flush();
			
			//读
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















































































