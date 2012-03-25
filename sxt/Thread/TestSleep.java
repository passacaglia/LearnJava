/**
*
*
*****/

import java.util.Date;

public class TestSleep {
	public static void main(String[] args) {
		RunnerSleep rs = new RunnerSleep();
		Thread t = new Thread(rs);
		t.start();
		
		try {
			Thread.sleep(3000);
			System.out.println("Main weakup!");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		//stop thread t.
		rs.shutDown();//这样来停止死循环。比较好。不要调用interrupted方法去停止，太粗暴。
		
	}
}

class RunnerSleep implements Runnable {
	boolean flag = true;
	public void run() {
		while(flag) {
			System.out.println("---" + new Date() + "---");
			try {
				//sleep(1000);//这样写不行，因为 这个类不是Thread的子类。无法调用Thread类的sleep方法。
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				return;
			}
		}
	}
	
	public void shutDown() {
		flag = false;
	}
}


