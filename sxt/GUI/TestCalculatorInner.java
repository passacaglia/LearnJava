/**
*内部类 （内部类可以使用private这个限定词）
*内部类：声明在一个class内部的。 
*好处：
*			方便的访问包装类的成员变量和方法。（相当于默认 拥有一个外部包装类的 引用）
*			更清楚的组织逻辑，防止不应该被其它类访问 的类  进行访问（从语法上就拒绝你访问。内部类可以使用private这个限定词）
*什么时候使用？
*			想让某个类访问  包装类 之成员变量的时候；
*			不想让/不需要  别的类   访问某个类时。
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
		
		//前面已经把num1定义成  类成员变量，故此处勿再写“TextField” num1. 编译无错，运行时错误不易找出。
		TextField num1 = new TextField(10);//10是文本框长度。10个字符。
		Label labPlus = new Label(" + ");
		num2 = new TextField(10);
		Button butEquals = new Button(" = ");
			butEquals.addActionListener(new CalMonitor());
		num3 = new TextField(10);
		f.add(num1);//按顺序哦。FlowLayout.
		f.add(labPlus);
		f.add(num2);
		f.add(butEquals);
		f.add(num3);
		
		f.pack();
		f.setVisible(true);
	}
	
	//Inner Class | private 让此内部类只能 由 包装类访问。
	private class CalMonitor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int n1 = Integer.parseInt(num1.getText());//对象+变量名访问之。
			int n2 = Integer.parseInt(num2.getText());
			num3.setText("" + (n1 + n2));//or (String.valueOf(n1 + n2))
		}
	}
	
}
