/**
*����1.ʵ��Runnable�ӿڡ����Ƽ����ַ�ʽ��������
*����2.��Thread��̳С�
*main���߳� �� t�߳� ����ִ�С�
**/

public class TestThread {
	public static void main(String[] args) {
		Runner001 r = new Runner001();
		//r.run();//��з������á�
		
		Thread t = new Thread(r);
		t.start();//��Ž��̵߳�������
		
		for (int j=0; j<100; j++) {
			System.out.println("Main: " + j);
		}
	}
}

/*
class Runner001 implements Runnable{
	public void run() {
		for (int j=0; j<100; j++) {
			System.out.println("Runner001: " + j);
		}
	}
}
*/

class Runner001 extends Thread{
	public void run() {
		for (int j=0; j<100; j++) {
			System.out.println("Runner001: " + j);
		}
	}
}