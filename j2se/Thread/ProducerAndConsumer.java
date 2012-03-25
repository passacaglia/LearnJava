/**
*wait/notify����	���õ�ǰ�᣺����������������˵��������synchronized�Ĵ����/������ʹ�á�
*
**/

public class ProducerAndConsumer {
	public static void main(String[] args) {
		Storage s = new Storage(15);
		Producer p1 = new Producer("p1", s);
		Producer p2 = new Producer("p2", s);
		Consumer c1 = new Consumer("c1", s);
		Consumer c2 = new Consumer("c2", s);
		
		Thread tp1 = new Thread(p1);
		Thread tp2 = new Thread(p2);
		Thread tc1 = new Thread(c1);
		Thread tc2 = new Thread(c2);
		
		tp1.start();
		tp2.start();
		tc1.start();
		tc2.start();
		
	}
}

class Storage {
	private int index;
	private int size;
	
	Storage(int size) {
		this.size = size;
	}
	
	/**
	*��synchronized������ִ��add������Storage����Ϊ�˱�֤del�������ܱ�ͬʱִ�У�del����ҲҪsynchronized��
	*
	**/
	public synchronized void add(String pName) {
		while(index == size) {
			try {
				this.wait();//������ˣ���֪ͨ�������Storage������ ����add�������߳�Producer������ȴ���Wait pool
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		/**
		*���������û����֪ͨ�����������(Storage)�ϵȴ��ģ��߳�A��������
		*���߳�A��Wait pool���� Lock pool��
		*�����˵�ʱ���߳�A�Ѿ�����ȴ���
		**/
		this.notify();
		index ++;//add��del��λ�ÿ��Ǻá�
		System.out.println(pName + " make index: " + index);
	}
	
	public synchronized void del(String cName) {
		while(index == 0) {
			try {
				this.wait();//û�ˣ���֪ͨ�������Storage������ ����del���� ��Consumer�̣߳����ҵȡ�
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		this.notify();//������У���֪ͨ�����Storage�����ϵȴ���Consumer�����Ѱɡ�
		System.out.println(cName + " used index: " + index);
		index --;
	}
}

class Producer implements Runnable {
	String pName;
	Storage sp;
	
	Producer(String pName, Storage sp) {
		this.pName = pName;
		this.sp = sp;
	}
	
	//Producer������������ѭ����
	//�����������ķ��� ���� Storage��û�����ˣ�����wait()��
	public void run() {
		while(true) {
			sp.add(pName);
			
			try {
				//System.out.println(pName + "��������");
				Thread.sleep((long)(Math.random() * 10000));//�������ˣ��ȴ�һ��ʱ�䣬��Ϣ�¡�
				//System.out.println(pName + "����");
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	String cName;
	Storage sc;
	
	Consumer(String cName, Storage sc) {
		this.cName = cName;
		this.sc = sc;
	}
	
	//Consumer�������ѣ���ѭ����
	//���������ѵķ��� ���� Storage��û�����ˣ�����wait()��
	public void run() {
		while(true) {
			sc.del(cName);
			
			try {
				//System.out.println(cName + "������");
				Thread.sleep((long)(Math.random() * 20000));//�������ˣ��ȴ�һ��ʱ�䣬��Ϣ�¡�
				//System.out.println(cName + "Ҫ׼�������ˡ�����");
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

//�����Ŀ죬index�����ӣ��л���ﵽ������
//���ѵĿ죬index�ͼ��ٵĿ죬indexһֱ����ô���ӡ�