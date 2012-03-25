/**
*优先级：
		常量（范围1-10，默认优先级5）
				Thread.MIN_PRIORITY = 1
				Thread.MAX_PRIORITY = 10
				Thread.NORM_PRIORITY = 5
		设置
				int getPriotiry();
				void setPriority(int newPriority);
*
*
*
*
**/

public class TestPriority {
	public static void main(String[] args) {
		TPrio1 tp1 = new TPrio1();
		TPrio2 tp2 = new TPrio2();
		Thread t1 = new Thread(tp1);
		Thread t2 = new Thread(tp2);
		
		t1.setPriority(t1.getPriority() + 3);//注释/不注释  观察输出内容的区别（注意：不论注释与否，每次的运行结果都是不同的）
		
		t1.start();
		t2.start();
	}
}

class TPrio1 implements Runnable {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("TPrio1 " + i);
		}
	}
}

class TPrio2 implements Runnable {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("tprio2 " + i);
		}
	}
}