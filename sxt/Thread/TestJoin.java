/**
*join�������ϲ��̣߳����൱�� �������ã�
*
*
*****/

public class TestJoin {
	public static void main(String[] args) {
		RunnerJoin rj = new RunnerJoin();
		Thread t = new Thread(rj, "t");
		t.start();
		
		try {
			t.join();//���ϲ��̣߳����൱�ڷ������ã�
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		for (int i=1; i<=10; i++) {
			System.out.println("I am the main thread.");
		}
	}
}

class RunnerJoin implements Runnable {
	public void run() {
		for (int i=1; i<=10; i++) {
			System.out.println("I am RunnerJoin.");//ȡ���̵߳����֣�ò���ô�����
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			return;
		}
	}
}