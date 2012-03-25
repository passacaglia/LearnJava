/**
*
*
*****/

import java.util.Date;

public class TestSleep {
	public static void main(String[] args) {
		RunnerSleep rs = new RunnerSleep();
		Thread t = new Thread(rs);
		t.start();
		
		try {
			Thread.sleep(3000);
			System.out.println("Main weakup!");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		//stop thread t.
		rs.shutDown();//������ֹͣ��ѭ�����ȽϺá���Ҫ����interrupted����ȥֹͣ��̫�ֱ���
		
	}
}

class RunnerSleep implements Runnable {
	boolean flag = true;
	public void run() {
		while(flag) {
			System.out.println("---" + new Date() + "---");
			try {
				//sleep(1000);//����д���У���Ϊ ����಻��Thread�����ࡣ�޷�����Thread���sleep������
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				return;
			}
		}
	}
	
	public void shutDown() {
		flag = false;
	}
}


