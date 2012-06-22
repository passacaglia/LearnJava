/**
*用于被共享使用的数据
*加过锁
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
			//这句话要放在上面System.out的下面，才会有t1和t2t2交错输出的现象。
			//加锁时要放在外面，才会有t1和t2t2交错输出的现象。
				/**
				*i自增后，接着打印出来。这两句话执行时，线程被暂停的几率较小。
				*接着100000000次空循环，时间较长，此线程被暂停去执行其他线程的几率大。
				*加锁了，替换了也没用。执行不了。
				**/
			
			//下面 的睡觉部分可以没有。
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}