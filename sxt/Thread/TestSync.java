/**
*����Ӧ��t1�ǵ�һ����t2�ڶ�������ʵ���϶��ǵڶ�����ԭ�����ڣ�t1��ִ�й����б�����ˡ�
*
*����ͬ����ʽ
*
**/

public class TestSync implements Runnable{
	Timer timer = new Timer();
	public static void main(String[] args) {
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	
	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}

class Timer {
	private static int num = 0;
	
	//����Ӧ��t1�ǵ�һ����t2�ڶ�������ʵ���϶��ǵڶ�����ԭ�����ڣ�t1��ִ�й����б�����ˡ�
	/*
	public void add(String name) {
		num ++;
		try {
			Thread.sleep(1);//�Ŵ�ִ��Ч��
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println(name + ", you are the " + num + "th thread who acess 'timer'.");
	} */
	
	//����
	public synchronized void add(String name) {//ִ�����������ʱ���������������
		//synchronized (this) {
			num ++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			System.out.println("You are the " + num + "th thread who access timer.");
		
		//}
	}
}