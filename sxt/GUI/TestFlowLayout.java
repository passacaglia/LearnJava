//

import java.awt.*;

public class TestFlowLayout {
	public static void main(String[] args) {
		Frame f = new Frame("Flow Layout");
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		
		f.setLayout(new FlowLayout());//默认居中对齐，可以设置。
		f.add(button1);
		f.add(button2);
		f.add(button3);
		f.setSize(300, 100);
		f.setVisible(true);
	}
}