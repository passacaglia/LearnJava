/**
*
*
*
*运行SyncShareData时，一直显示的是t1线程在执行。
*
*
*
*
**/

public class TestThreadSD {
	public static void main(String[] args) {
		SyncShareData ssd = new SyncShareData();
		Thread t1 = new Thread(ssd, "t1");
		Thread t2 = new Thread(ssd, "t2t2");
		
		t1.start();
		t2.start();
	}
}