/**
*wait/notify方法	调用的前提：对象已锁定。就是说，必须在synchronized的代码块/方法中使用。
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
	*用synchronized方法，执行add，锁定Storage对象。为了保证del方法不能被同时执行，del方法也要synchronized。
	*
	**/
	public synchronized void add(String pName) {
		while(index == size) {
			try {
				this.wait();//如果满了，就通知正在这个Storage对象上 调用add方法的线程Producer，进入等待。Wait pool
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		/**
		*如果容器里没满，通知（在这个对象(Storage)上等待的）线程A，生产。
		*让线程A从Wait pool进入 Lock pool。
		*（满了的时候，线程A已经进入等待）
		**/
		this.notify();
		index ++;//add和del，位置考虑好。
		System.out.println(pName + " make index: " + index);
	}
	
	public synchronized void del(String cName) {
		while(index == 0) {
			try {
				this.wait();//没了，就通知正在这个Storage对象上 调用del方法 的Consumer线程，给我等。
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		this.notify();//如果还有，就通知在这个Storage对象上等待的Consumer，消费吧。
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
	
	//Producer就是生产，死循环。
	//不让他生产的方法 就是 Storage里没东西了，调用wait()。
	public void run() {
		while(true) {
			sp.add(pName);
			
			try {
				//System.out.println(pName + "生产完了");
				Thread.sleep((long)(Math.random() * 10000));//生产完了，等待一段时间，休息下。
				//System.out.println(pName + "醒来");
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
	
	//Consumer就是消费，死循环。
	//不让他消费的方法 就是 Storage里没东西了，调用wait()。
	public void run() {
		while(true) {
			sc.del(cName);
			
			try {
				//System.out.println(cName + "消费了");
				Thread.sleep((long)(Math.random() * 20000));//消费完了，等待一段时间，休息下。
				//System.out.println(cName + "要准备消费了。。。");
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

//生产的快，index就增加，有机会达到容量。
//消费的快，index就减少的快，index一直不怎么增加。