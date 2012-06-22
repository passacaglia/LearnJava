/*�������ͬ��һ���¼�������ķ�����
 *ò�Ƶ�� �رհ�ť��ʱ���������ڶ����ر��ˡ�
 *����WindowEventHandlerM2�����������
 *ԭ��ܼ򵥣��رյ�ʱ�� ���õ���System.exit(0);
 */

import java.awt.*;
import java.awt.event.*;

public class WindowEventMultiplexer2 {
	public static void main(String[] args) {
		Frame f1 = new Frame("Main");
		//WindowEventHandlerM2 wehm = new WindowEventHandlerM2();
		f1.addWindowListener(new WindowEventHandlerM2());
		f1.setBounds(100, 100, 200, 200);
		
		Frame f2 = new Frame("Another");
		//WindowEventHandlerM2 wehm2 = new WindowEventHandlerM2();
		f2.addWindowListener(new WindowEventHandlerM2());
		f2.setBounds(300, 300, 200, 200);
		
		f1.setVisible(true);
		f2.setVisible(true);
	}
}


class WindowEventHandlerM2 extends WindowAdapter{
	public void windowActivated(WindowEvent e) {
		Frame f = (Frame)e.getSource();
		System.out.println(f.getTitle() + " activated.");
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}