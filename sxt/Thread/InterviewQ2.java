/**
*线程t1先启动。执行的是方法m1，取得对象inq2的锁。把b改成1000之后，抱着锁睡5秒。
*主线程main，调用了未加锁的方法m2。无需取得锁。2.5秒之后，又直接把b改成2000。然后在main方法中打印出来。
*之后，线程t1的m1方法打印b。这时是2000了。
*
*
*所以啊，b是共享资源。要保护的话，所有调用b的方法。考虑好，加锁的话，都加锁。
*
**/


public class InterviewQ2 implements Runnable {
	int b = 100;
	
	public synchronized void m1(){
		b = 1000;
		
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("b = " + b);
	}
	
	public void m2() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		b = 2000;
	}
	
	public void run() {
			m1();
	}
	
	public static void main(String[] args) throws Exception{
		InterviewQ2 inq2 = new InterviewQ2();
		Thread t1 = new Thread(inq2);
		t1.start();//会先睡5秒
		
		inq2.m2();
		System.out.println("inq2" + inq2.b);
	}
}

