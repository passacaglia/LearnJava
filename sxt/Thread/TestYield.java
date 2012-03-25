/**
*yield,�ó�CPU��ʹ��Ȩ��
*TestYield.txt���������н����������ע�ͣ���Ҫ���ǵ���
*��i�ܱ�10������ʱ���ó�CPUʹ��Ȩ�������أ�CPU�����ֻ�ѡ������̵߳ġ�
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
		super(s);//���߳�������ò���ô�����
	}
	
	
	public void run() {
		for (int i=1; i<=100; i++) {
			System.out.println(getName() + " : " + i);
			if ((i%10) == 0) {
				Thread.yield();//��i�ܱ�100������ʱ���ó�CPUʹ��Ȩ�������أ�CPU�����ֻ�ѡ������̵߳ġ�
				System.out.println(getName() + " yield == ==");
				
				//yieldЧ�������ԣ��ʼ���sleep��ǿЧ����
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