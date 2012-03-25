/**
*本来应该t1是第一个，t2第二个。但实际上都是第二个，原因在于：t1在执行过程中被打断了。
*
*两种同步方式
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
	
	//本来应该t1是第一个，t2第二个。但实际上都是第二个，原因在于：t1在执行过程中被打断了。
	/*
	public void add(String name) {
		num ++;
		try {
			Thread.sleep(1);//放大执行效果
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println(name + ", you are the " + num + "th thread who acess 'timer'.");
	} */
	
	//加锁
	public synchronized void add(String name) {//执行这个方法的时候，锁定这个方法。
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