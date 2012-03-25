//һ��Listener�����������Button����ô������������ť�أ�

//����Button�����setActionCommand������������action command��
//��Ĭ��action command��button label��ͬ�� 
//����Ȼ������Button���������֣����ǻ���Button������ͬ��ʱ�򡣣� 

//FrameĬ����BorderLayout������ÿ������ֻ�ܷ�һ��component����(�ȷ���ı������ĸ��ǵ�)
//���ԣ��ǵ�ָ��Ҫ�ŵ�λ�á�

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent2 {
	public static void main(String[] args) {
		Frame f = new Frame("Action Event test 2");
		Button b1 = new Button("start");
		Button b2 = new Button("stop");
		
		Monitor2 m2 = new Monitor2();
		b1.addActionListener(m2);
		b2.addActionListener(m2);
		b2.setActionCommand("game over");
		
		//f.add(b1, BorderLayout.NORTH);
		//f.add(b2, BorderLayout.SOUTH);
		f.add(b1, BorderLayout.WEST);
		f.add(b2, BorderLayout.EAST);
		f.pack();
		f.setVisible(true);
	}
}


class Monitor2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println(" " + e.getActionCommand());
	}
}