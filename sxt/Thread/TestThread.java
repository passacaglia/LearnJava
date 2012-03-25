/**
*方法1.实现Runnable接口。（推荐这种方式。更加灵活）
*方法2.从Thread类继承。
*main主线程 和 t线程 交替执行。
**/

public class TestThread {
	public static void main(String[] args) {
		Runner001 r = new Runner001();
		//r.run();//这叫方法调用。
		
		Thread t = new Thread(r);
		t.start();//这才叫线程的启动。
		
		for (int j=0; j<100; j++) {
			System.out.println("Main: " + j);
		}
	}
}

/*
class Runner001 implements Runnable{
	public void run() {
		for (int j=0; j<100; j++) {
			System.out.println("Runner001: " + j);
		}
	}
}
*/

class Runner001 extends Thread{
	public void run() {
		for (int j=0; j<100; j++) {
			System.out.println("Runner001: " + j);
		}
	}
}