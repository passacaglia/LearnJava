/**
*�ڲ��� ���ڲ������ʹ��private����޶��ʣ�
*�ڲ��ࣺ������һ��class�ڲ��ġ� 
*�ô���
*			����ķ��ʰ�װ��ĳ�Ա�����ͷ��������൱��Ĭ�� ӵ��һ���ⲿ��װ��� ���ã�
*			���������֯�߼�����ֹ��Ӧ�ñ���������� ����  ���з��ʣ����﷨�Ͼ;ܾ�����ʡ��ڲ������ʹ��private����޶��ʣ�
*ʲôʱ��ʹ�ã�
*			����ĳ�������  ��װ�� ֮��Ա������ʱ��
*			������/����Ҫ  �����   ����ĳ����ʱ��
*
********/

import java.awt.*;
import java.awt.event.*;

public class TestCalculatorInner {
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
		TextField num1 = new TextField(10);//10���ı��򳤶ȡ�10���ַ���
		Label labPlus = new Label(" + ");
		num2 = new TextField(10);
		Button butEquals = new Button(" = ");
			butEquals.addActionListener(new CalMonitor());
		num3 = new TextField(10);
		f.add(num1);//��˳��Ŷ��FlowLayout.
		f.add(labPlus);
		f.add(num2);
		f.add(butEquals);
		f.add(num3);
		
		f.pack();
		f.setVisible(true);
	}
	
	//Inner Class | private �ô��ڲ���ֻ�� �� ��װ����ʡ�
	private class CalMonitor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int n1 = Integer.parseInt(num1.getText());//����+����������֮��
			int n2 = Integer.parseInt(num2.getText());
			num3.setText("" + (n1 + n2));//or (String.valueOf(n1 + n2))
		}
	}
	
}
