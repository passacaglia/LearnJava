/**
*���ڱ�����ʹ�õ�����
*�ӹ���
**/

public class SyncShareData implements Runnable {
	private int i;
	
	public void run()	{
		while (i<50) {
			synchronized(this) {
				i++;
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
			for(int j=0; j<100000000; j++) {}
			//��仰Ҫ��������System.out�����棬�Ż���t1��t2t2�������������
			//����ʱҪ�������棬�Ż���t1��t2t2�������������
				/**
				*i�����󣬽��Ŵ�ӡ�����������仰ִ��ʱ���̱߳���ͣ�ļ��ʽ�С��
				*����100000000�ο�ѭ����ʱ��ϳ������̱߳���ͣȥִ�������̵߳ļ��ʴ�
				*�����ˣ��滻��Ҳû�á�ִ�в��ˡ�
				**/
			
			//���� ��˯�����ֿ���û�С�
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}