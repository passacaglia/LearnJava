//一个Listener对象监听两个Button，怎么区分这两个按钮呢？

//调用Button对象的setActionCommand方法，更改其action command。
//（默认action command与button label相同） 
//（虽然可以用Button的名字区分，但是会有Button名字相同的时候。） 

//Frame默认是BorderLayout，而且每个区域只能放一个component对象。(先放入的被后放入的覆盖掉)
//所以，记得指定要放的位置。

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