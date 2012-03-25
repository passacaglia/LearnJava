/**
	TCP: 
	Server： 
	建立一个ServerSocket对象，监听在某个端口上； 
	调用accept方法接收一个连接； 
	接收到连接后，用Input & Output进行通话； 
	最后别忘了关闭 流/Socket对象。
	Client： 
	new Socket对象，连到服务器上； 
	拿到Input & Output后开始互相通话； 
	关闭。


 */


import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(6666);
		while(true) {
			Socket serverS = ss.accept();//这里不是新建一个Socket。而是把监听到的 接入 创建为一个新Socket。
			System.out.println("A client connected.");
			
			InputStream is = serverS.getInputStream();//取得输入管道。
			DataInputStream dis = new DataInputStream(is);//处理。
			System.out.println(dis.readUTF());//打印出读到的东西。
			
			//获取 连入的 socket 相关信息。
			System.out.println(serverS.getInetAddress() + "#" + serverS.getPort());
			
		}
	}
}