import java.awt.*;
import java.awt.event.*;

public class TestChoice extends Frame {
	
	Choice choice = null;
	ItemMonitor im = new ItemMonitor();
	int count = 0;
	
	public static void main(String[] args) {
		new TestChoice().launch();
	}
	
	public void launch() {
		setLocation(300, 200);
		
		choice = new Choice();
		choice.addItemListener(im);
		
		for (int i=0; i<5; i++) {
			choice.add("item " + i);
		}
		
		choice.select(choice.getItemCount() - 1);
		choice.insert("item 5", choice.getItemCount());
		
		
		add(choice, BorderLayout.NORTH);
		
		pack();
		setVisible(true);
		
		System.out.println("Total " + choice.getItemCount() + " items.");
	}
	
	private class ItemMonitor implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Choice c = (Choice)e.getSource();
			
			System.out.println("Selected item index: " 
												 + c.getSelectedIndex());
			System.out.println("Selected item : " 
												 + c.getSelectedItem());
			
			count ++;
			if (count == 9) {
				choice.remove("item 3");
			}
			
		}
	}
	
	
}