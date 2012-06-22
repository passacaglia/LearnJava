/**
*带滚动条的Panel
*
*
*
**/


import java.awt.*;
import java.awt.event.*;

public class TestScrollPane extends Frame {
	
	ScrollPane sp = null;
	FlowLayout fl = new FlowLayout();
	Panel p = new Panel(fl);
	
	
	public static void main(String[] args) {
		new TestScrollPane().launch();	
	}
	
	public void launch() {
		setLocation(300, 200);
		
		sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);
		add(sp, BorderLayout.CENTER);
		
		Button[] button = new Button[6];
		for (int i=0; i<button.length; i++) {
			button[i] = new Button("Button " + i);
			p.add(button[i]);
		}
		
		
		pack();
		setVisible(true);
	}
	
	
}