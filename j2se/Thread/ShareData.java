/**
*用于被共享使用的数据
**/

public class ShareData implements Runnable{
	int i;
	public void run() {
			while(i<10) {
					i++;
					for (int j=0; j<10000000; j++) {}//空循环，让 正在运行的线程 有机会被替换下来。
					System.out.println(Thread.currentThread().getName() + " : " + i);
			}
	}
}