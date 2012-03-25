/**
*���жԷ����á�
*�õ�ĳ����������ã�����˭����˭��
*�����Ա�����������Ա�����Ǻã�
*
*
*****
*������
*TestCalculator �� Calculator���Ժϲ�������
********/

import java.awt.*;
import java.awt.event.*;

public class TestCalculator {
	public static void main(String[] args) {
		new Calculator().launchFrame();
	}
}


class Calculator extends Frame {
	
	TextField num1, num2, num3;
	
	public void launchFrame() {
		Frame f = new Frame("Calculator test");
		f.setLayout(new FlowLayout());
		
		//ǰ���Ѿ���num1�����  ���Ա�������ʴ˴�����д��TextField�� num1. �����޴�����ʱ�������ҳ���
		num1 = new TextField(10);//10���ı��򳤶ȡ�10���ַ���
		Label labPlus = new Label(" + ");
		num2 = new TextField(10);
		Button butEquals = new Button(" = ");
			butEquals.addActionListener(new CalMonitor(this));
		num3 = new TextField(10);
		f.add(num1);//��˳��Ŷ��FlowLayout.
		f.add(labPlus);
		f.add(num2);
		f.add(butEquals);
		f.add(num3);
		
		f.pack();
		f.setVisible(true);
	}
}


class CalMonitor implements ActionListener {
	
	private Calculator c;
	
	CalMonitor(Calculator c) {
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(c.num1.getText());//����+����������֮��
		int n2 = Integer.parseInt(c.num2.getText());
		c.num3.setText("" + (n1 + n2));//or (String.valueOf(n1 + n2))
	}
}