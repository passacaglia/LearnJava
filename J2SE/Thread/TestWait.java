/**
*线程A运行wait(10000);
*运行中又切换到了 别的线程B， 此A暂停了是吧。
*那么再切换回来时，A暂停的这段时间算不算在10s之内？
**/

import java.util.Date;

public class TestWait {
	public static void main(String[] args) {
		Runner1 r1 = new Runner1();
		Runner2 r2 = new Runner2();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
	
	public void run() {
		
	}
}

class Runner1 implements Runnable {
	public void run() {
		try {
			System.out.println("=== Runner1 ===" + new Date() + "===" + new Date().getTime());
			Thread.sleep(10000);
			System.out.println("=== Runner1 ===" + new Date() + "===" + new Date().getTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Runner2 implements Runnable {
	public void run() {
		try {
			System.out.println("=== Runner2 === " + new Date() + "===" + new Date().getTime());
			Thread.sleep(10000);
			System.out.println("=== Runner2 ===" + new Date() + "===" + new Date().getTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}