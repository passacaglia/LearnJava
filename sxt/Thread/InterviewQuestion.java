/**
�߳�A����m1�������߳�B�ǲ����ٷ��ʷ���m1.
���ǣ��߳�B�ǿ��Է���m2�����ġ�
*/

public class InterviewQuestion implements Runnable {
	int b = 100;
	
	public synchronized void m1(){//������Ŀ���ǲ����������䱻���
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
		t1.start();//����˯5��
		
		Thread.sleep(1000);//��֤t1�Ѿ�������
		inq.m2();
	}
}

