//

import java.awt.*;

public class TestFlowLayout2 {
	public static void main(String[] args) {
		Frame f = new Frame();
		
		//主要是看这里。居中对齐，水平距20，垂直40.
		FlowLayout l = new FlowLayout(FlowLayout.CENTER, 20, 40);
		f.setLayout(l);
		f.setLocation(300, 400);//和Size可以 合起来 成为setBorder
		f.setSize(300, 200);//
		f.setBackground(new Color(204, 204, 255));
		for (int i=1; i<7; i++) {
			f.add(new Button("BUTTON"));
		}
		f.setVisible(true);
	}
}