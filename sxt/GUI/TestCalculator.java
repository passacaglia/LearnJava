/**
*持有对方引用。
*拿到某个对象的引用，想用谁就用谁。
*（类成员变量、对象成员，考虑好）
*
*
*****
*其他：
*TestCalculator 和 Calculator可以合并起来。
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
		
		//前面已经把num1定义成  类成员变量，故此处勿再写“TextField” num1. 编译无错，运行时错误不易找出。
		num1 = new TextField(10);//10是文本框长度。10个字符。
		Label labPlus = new Label(" + ");
		num2 = new TextField(10);
		Button butEquals = new Button(" = ");
			butEquals.addActionListener(new CalMonitor(this));
		num3 = new TextField(10);
		f.add(num1);//按顺序哦。FlowLayout.
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
		int n1 = Integer.parseInt(c.num1.getText());//对象+变量名访问之。
		int n2 = Integer.parseInt(c.num2.getText());
		c.num3.setText("" + (n1 + n2));//or (String.valueOf(n1 + n2))
	}
}