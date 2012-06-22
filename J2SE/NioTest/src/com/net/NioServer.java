package com.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
	public static final int SERVERPORT = 5555;
	public static final String USERNAME = "wangzhirong";
	public static final String PASSWORD = "123456";
	public static final String ISACK = "ACK";
	public static final String ISNAK = "NAK!";
	// Selector selector;//ѡ����
	// SelectionKey key;//key�� һ��key����һ��Selector ��NIOͨ���ϵ�ע��,��������;
	// //ȡ�����Key��Ϳ��Զ�Selector��ͨ���Ͻ��в���
	private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);// ͨ�����ݻ�����

	public NioServer() {
	}

	public static void main(String[] args) throws IOException {
		NioServer ns = new NioServer();
		ns.BuildNioServer();
	}

	public void BuildNioServer() throws IOException {
		// ///////////////////////////////////////////////////////
		// /////�ȶԷ���˵�ServerSocket����ע��,ע�ᵽSelector ////
		// ///////////////////////////////////////////////////////
		ServerSocketChannel ssc = ServerSocketChannel.open();// �½�NIOͨ��
		ssc.configureBlocking(false);// ʹͨ��Ϊ������
		ServerSocket ss = ssc.socket();// ��������NIOͨ����socket����
		// �½�socketͨ���Ķ˿�
		ss.bind(new InetSocketAddress("127.0.0.1", SERVERPORT));
		Selector selector = Selector.open();// ��ȡһ��ѡ����
		// ��NIOͨ��ѡ�󶨵�����,��Ȼ�󶨺���������Ϊskey
		SelectionKey skey = ssc.register(selector, SelectionKey.OP_ACCEPT);
		// //////////////////////////////////////////////////////////////////
		// // ���տͻ��˵�����Socket,������SocketҲ����ע�ᵽSelector ////
		// /////////////////////////////////////////////////////////////////
		while (true) {
			int num = selector.select();// ��ȡͨ�����Ƿ���ѡ�����Ĺ����¼�
			if (num < 1) {
				continue;
			}
			Set selectedKeys = selector.selectedKeys();// ��ȡͨ���ڹ����¼��ļ���
			Iterator it = selectedKeys.iterator();
			while (it.hasNext()) {// ����ÿ���¼�
				try {
					SelectionKey key = (SelectionKey) it.next();
					// ��һ�������ӽ����¼�,������¼�
					if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
						// �������������
						ServerSocketChannel serverChanel = (ServerSocketChannel) key
								.channel();
						// ��serverSocketChannel�д�������ͻ��˵�����socketChannel
						SocketChannel sc = serverChanel.accept();
						sc.configureBlocking(false);
						// Add the new connection to the selector
						// ��������ע�ᵽѡ����
						SelectionKey newKey = sc.register(selector,
								SelectionKey.OP_READ);
						it.remove();
						System.out.println("Got connection from " + sc);
					} else
					// ���ͻ������ݵ��¼�,��ʱ�пͻ��˷����ݹ���,�ͻ����¼�
					if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
						// ��ȡ����
						SocketChannel sc = (SocketChannel) key.channel();
						int bytesEchoed = 0;
						while ((bytesEchoed = sc.read(echoBuffer)) > 0) {
							System.out.println("bytesEchoed:" + bytesEchoed);
						}
						echoBuffer.flip();
						System.out.println("limet:" + echoBuffer.limit());
						byte[] content = new byte[echoBuffer.limit()];
						echoBuffer.get(content);
						String result = new String(content);
						doPost(result, sc);
						echoBuffer.clear();
						it.remove();
					}
				} catch (Exception e) {
				}
			}
		}
	}

	public void doPost(String str, SocketChannel sc) {
		boolean isok = false;
		int index = str.indexOf('|');
		if (index > 0) {
			String name = str.substring(0, index);
			String pswd = str.substring(index + 1);
			if (pswd == null) {
				pswd = "";
			}
			if (name != null) {
				if (name.equals(USERNAME) && pswd.equals(PASSWORD)) {
					isok = true;
				} else {
					isok = false;
				}
			} else {
				isok = false;
			}
		} else {
			isok = false;
		}
		String result = "";
		if (isok) {
			result = "ACK";
		} else {
			result = "NAK!";
		}
		ByteBuffer bb = ByteBuffer.allocate(result.length());
		bb.put(result.getBytes());
		bb.flip();
		try {
			sc.write(bb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bb.clear();
	}

}