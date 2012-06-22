/**
*setEnabled() | isEnabled()是否可用
*getState() | setState() 是否选中
*/


import java.awt.*;
import java.awt.event.*;

public class TestCheckbox extends Frame{
	
	Checkbox checkbox = new Checkbox();
	Checkbox[] cb = new Checkbox[3];
	Label lb = null;

	public static void main(String[] args) {
		new TestCheckbox().launch();
	}
	
	public void launch() {
		setLocation(350, 200);
		setLayout(new GridLayout(5, 1));
		
		ItemMonitor im = new ItemMonitor();
		//checkbox
		checkbox.setLabel("test");
		checkbox.addItemListener(im);
		add(checkbox);
		
		for (int i=0; i<3; i++) {
			cb[i] = new Checkbox("item " + i);
			cb[i].addItemListener(im);
			add(cb[i]);
			
			if (checkbox.getState() == true) {
				cb[i].setEnabled(true);
			} else {
				cb[i].setEnabled(false);
			}
			
			if (i == 2) {
				cb[i].setState(true);
			}
		}
		
		//label
		lb = new Label();
		add(lb);
		
		
		pack();
		setVisible(true);
	}
	
	private class ItemMonitor implements ItemListener {
		
		public void itemStateChanged(ItemEvent e) {
			Checkbox ch = (Checkbox)e.getSource();
		  String label = ch.getLabel();
			
			if (checkbox.getState() == true) {
				for (int i=0; i<3; i++) {
					cb[i].setEnabled(true);
				}
			} else if (checkbox.getState() == false) {
				for (int i=0; i<3; i++) {
					cb[i].setEnabled(false);
				}
			}
			
			if (e.getStateChange() == ItemEvent.SELECTED) {
				System.out.println(label + " selected.");
				lb.setText(label + " selected.");
			} else {
				System.out.println(label + " deselected.");
				lb.setText(label + " deselected.");
			}
		}
	}



}