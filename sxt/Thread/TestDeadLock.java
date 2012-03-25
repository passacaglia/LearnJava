/**
*ʹ��o1��o2ֻ����ʾ��
*
*
*��һ���߳���  ģ�� �����߳�
**********/

public class TestDeadLock implements Runnable {
	
	public int flag;
	static Object obj1 = new Object();//Ϊʲô�����Ǿ�̬Object������ס��
	static Object obj2 = new Object();
	
	public static void main(String[] args) {
		TestDeadLock dl1 = new TestDeadLock();
		TestDeadLock dl2 = new TestDeadLock();
		dl1.flag = 1;
		dl2.flag = 2;
		
		Thread t1 = new Thread(dl1);
		Thread t2 = new Thread(dl2);
		
		t1.start();
		t2.start();
	}
	
	
	public void run() {
		if(flag == 1) {
			synchronized(obj1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				
				synchronized(obj2) {
					System.out.println("1");
				}
			}
		}
		
		if(flag == 2) {
			synchronized(obj2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				
				synchronized(obj1) {
					System.out.println("2");
				}
			}
		}
	}
}

