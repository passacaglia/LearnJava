/**
*使用o1和o2只是演示。
*
*
*用一个线程类  模拟 两个线程
**********/

public class TestDeadLock implements Runnable {
	
	public int flag;
	static Object obj1 = new Object();//为什么必须是静态Object才能锁住？
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

