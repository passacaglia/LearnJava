/**
*yield,让出CPU的使用权。
*TestYield.txt里面有运行结果。（内有注释，不要覆盖掉）
*当i能被10整除的时候，让出CPU使用权。不过呢，CPU可能又会选中这个线程的。
*
*******/

public class TestYield {
	public static void main(String[] args) {
		MyThreadYield t1 = new MyThreadYield("t1");
		MyThreadYield t2 = new MyThreadYield("t2t2");
		
		t1.start();
		t2.start();
		
	}
}

class MyThreadYield extends Thread {
	MyThreadYield(String s) {
		super(s);//给线程命名，貌似用处不大。
	}
	
	
	public void run() {
		for (int i=1; i<=100; i++) {
			System.out.println(getName() + " : " + i);
			if ((i%10) == 0) {
				Thread.yield();//当i能被100整除的时候，让出CPU使用权。不过呢，CPU可能又会选中这个线程的。
				System.out.println(getName() + " yield == ==");
				
				//yield效果不明显，故加上sleep增强效果。
				try {
					System.out.println(getName() + " sleep");
					Thread.sleep(3000);
					System.out.println(getName() + " sleep weak");
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}
}