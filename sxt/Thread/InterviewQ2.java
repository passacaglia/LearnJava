/**
*�߳�t1��������ִ�е��Ƿ���m1��ȡ�ö���inq2��������b�ĳ�1000֮�󣬱�����˯5�롣
*���߳�main��������δ�����ķ���m2������ȡ������2.5��֮����ֱ�Ӱ�b�ĳ�2000��Ȼ����main�����д�ӡ������
*֮���߳�t1��m1������ӡb����ʱ��2000�ˡ�
*
*
*���԰���b�ǹ�����Դ��Ҫ�����Ļ������е���b�ķ��������Ǻã������Ļ�����������
*
**/


public class InterviewQ2 implements Runnable {
	int b = 100;
	
	public synchronized void m1(){
		b = 1000;
		
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("b = " + b);
	}
	
	public void m2() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		b = 2000;
	}
	
	public void run() {
			m1();
	}
	
	public static void main(String[] args) throws Exception{
		InterviewQ2 inq2 = new InterviewQ2();
		Thread t1 = new Thread(inq2);
		t1.start();//����˯5��
		
		inq2.m2();
		System.out.println("inq2" + inq2.b);
	}
}

