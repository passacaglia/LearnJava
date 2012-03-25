/**
线程A访问m1方法。线程B是不能再访问方法m1.
但是，线程B是可以访问m2方法的。
*/

public class InterviewQuestion implements Runnable {
	int b = 100;
	
	public synchronized void m1(){//加锁的目的是不让下面的语句被打断
		b = 1000;
		
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("b = " + b);
	}
	
	public void m2() {
		System.out.println(b);
	}
	
	public void run() {
			m1();
	}
	
	public static void main(String[] args) throws Exception{
		InterviewQuestion inq = new InterviewQuestion();
		Thread t1 = new Thread(inq);
		t1.start();//会先睡5秒
		
		Thread.sleep(1000);//保证t1已经启动。
		inq.m2();
	}
}

