import java.awt.*;
import java.awt.event.*;

public class TestList extends Frame {
	
	List list;
	ItemMonitor im = new ItemMonitor();
	
	public static void main(String[] args) {
		new TestList().launch();
	}
	
	public void launch() {
		setLocation(300, 200);
		
		list = new List(5, true);//显示出来的个数 |是否支持多选。
		list.addItemListener(im);
		
		for (int i=2; i<12; i++) {
			list.add("item " + i);
		}
		
		add(list, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	private class ItemMonitor implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			List l = (List)e.getSource();
			int[] index = l.getSelectedIndexes();
			String[] str = l.getSelectedItems();
			
			for (int i=0; i<index.length; i++) {
				System.out.println(index[i] + " " + str[i]);
			}	
			System.out.println();	
			
		}
	}
	
	
}