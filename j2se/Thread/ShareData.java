/**
*���ڱ�����ʹ�õ�����
**/

public class ShareData implements Runnable{
	int i;
	public void run() {
			while(i<10) {
					i++;
					for (int j=0; j<10000000; j++) {}//��ѭ������ �������е��߳� �л��ᱻ�滻������
					System.out.println(Thread.currentThread().getName() + " : " + i);
			}
	}
}