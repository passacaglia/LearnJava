/**
*���ȼ���
		��������Χ1-10��Ĭ�����ȼ�5��
				Thread.MIN_PRIORITY = 1
				Thread.MAX_PRIORITY = 10
				Thread.NORM_PRIORITY = 5
		����
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
		
		t1.setPriority(t1.getPriority() + 3);//ע��/��ע��  �۲�������ݵ�����ע�⣺����ע�����ÿ�ε����н�����ǲ�ͬ�ģ�
		
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