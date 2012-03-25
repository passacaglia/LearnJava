import java.awt.*;
import java.awt.event.*;

public class TestTextArea extends Frame {
	
	public static void main(String[] args) {
		new TestTextArea().launch();
	}
	
	public void launch() {
		setLocation(300, 200);
		setLayout(new GridLayout(4, 1));
		
		String str = "1234567890 234567890 34567890 4567890 567890 ";
		
		TextArea ta1 = new TextArea(str, 2, 10, TextArea.SCROLLBARS_NONE);
		TextArea ta2 = new TextArea(str, 2, 10, TextArea.SCROLLBARS_HORIZONTAL_ONLY);
		TextArea ta3 = new TextArea(str, 2, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
		TextArea ta4 = new TextArea(str, 2, 10, TextArea.SCROLLBARS_BOTH);
		
		add(ta1);
		add(ta2);
		add(ta3);
		add(ta4);
		pack();
		
		
		ta1.append(" hello");
		ta2.replaceRange("Hello", 12, 16);
		
		
		setVisible(true);
	}
	
	
}