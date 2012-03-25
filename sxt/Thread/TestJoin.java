/**
*join方法（合并线程）（相当于 方法调用）
*
*
*****/

public class TestJoin {
	public static void main(String[] args) {
		RunnerJoin rj = new RunnerJoin();
		Thread t = new Thread(rj, "t");
		t.start();
		
		try {
			t.join();//（合并线程）（相当于方法调用）
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
			System.out.println("I am RunnerJoin.");//取得线程的名字，貌似用处不大
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			return;
		}
	}
}