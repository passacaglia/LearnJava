import java.awt.*;
import java.awt.event.*;

public class TestMenu {
	
	Frame f = null;
	Label l = null;
	PopupMenu pm = null;
	ActionMonitor am = new ActionMonitor();
	
	public static void main(String[] args) {
		new TestMenu().launch();
	}
	
	public void launch() {
		f = new Frame();
		f.setLocation(300, 200);
		
		f.addMouseListener(new MouseMonitor());
		
		MenuItem item1_1 = new MenuItem("Item1_1");
		MenuItem item1_2 = new MenuItem("Item1_2");
		MenuItem item1_3 = new MenuItem("Item1_3");
		item1_1.addActionListener(am);
		item1_2.addActionListener(am);
		item1_3.addActionListener(am);
		
		Menu item1 = new Menu("Item1", false);//等一下设为true试试。
		item1.add(item1_1);
		item1.add(item1_2);
		item1.add(item1_3);
		
		MenuShortcut ms = new MenuShortcut(KeyEvent.VK_A);
		
		MenuItem item2 = new MenuItem("Item2", ms);
		item2.addActionListener(am);
		
		CheckboxMenuItem item3 = new CheckboxMenuItem("Item3");
		item3.addItemListener(new ItemMonitor());
		
		Menu menu1 = new Menu("Menu1");
		menu1.add(item1);
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		
		MenuItem popup1 = new MenuItem("popup1");
		MenuItem popup2 = new MenuItem("popup2");
		popup1.addActionListener(am);
		popup2.addActionListener(am);
		
		pm = new PopupMenu();
		pm.add(popup1);
		pm.add(popup2);
		
		MenuBar mb = new MenuBar();
		mb.add(menu1);
		f.setMenuBar(mb);
		
		l = new Label("No menu item selected!");
		
		Menu help = new Menu("Help");
	  MenuItem help1 = new MenuItem("Index");
		MenuItem help2 = new MenuItem("About");
		help1.addActionListener(am);
		help2.addActionListener(am);
		help.add(help1);
		help.addSeparator();
		help.add(help2);
		
		mb.add(help);
		f.add(pm);
		f.add(l, BorderLayout.NORTH);	
		f.setSize(400, 300);//注意别点在label上面了。
		
		f.setVisible(true);
	}
	
	private class MouseMonitor extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
System.out.println(super.toString());			
			pm.show(f, e.getX(), e.getY());
		}
	}
	
	private class ActionMonitor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MenuItem mi = (MenuItem)e.getSource();
			l.setText(mi.getLabel() + " selected!");
			
		}
	}
	
	private class ItemMonitor implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			CheckboxMenuItem cmi = (CheckboxMenuItem)e.getSource();
			l.setText(cmi.getLabel() + " selected!");
		}
	}
	
	
}