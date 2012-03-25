import javax.swing.*;

import java.awt.*;


class TestToolTip extends JFrame {

	private static final int WINDOW_WIDTH = 300, WINDOW_HEIGHT = 200;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static int posX = (int)(tk.getScreenSize().getWidth()/2 - WINDOW_WIDTH/2);
	private static int posY = (int)(tk.getScreenSize().getHeight()/2 - WINDOW_HEIGHT*3/4);
	
	
	Icon newIcon = new ImageIcon(TestToolTip.class.getClassLoader().getResource("img/new.gif"));
	Icon openIcon = new ImageIcon(TestToolTip.class.getClassLoader().getResource("img/open.gif"));
	Icon saveIcon = new ImageIcon(TestToolTip.class.getClassLoader().getResource("img/save.gif"));
	Icon cutIcon = new ImageIcon(TestToolTip.class.getClassLoader().getResource("img/cut.gif"));
	Icon copyIcon = new ImageIcon(TestToolTip.class.getClassLoader().getResource("img/copy.gif"));
	Icon pasteIcon = new ImageIcon(TestToolTip.class.getClassLoader().getResource("img/paste.gif"));
	
	Icon[] icons = { newIcon, openIcon, saveIcon,
					 cutIcon, copyIcon, pasteIcon};
	
	String[] toolTips = { "New", "Open", "Save",
						  "Cut", "Copy", "Paste"};
	
	TestToolTip() {
		Container c = this.getContentPane();
		JToolBar toolBar = new JToolBar();
		toolBar.setMargin(new Insets(5, 5, 5, 5));
		
		for (int i=0; i<6; i++) {
			JButton button = new JButton(icons[i]);
			button.setToolTipText(toolTips[i]);
			toolBar.add(button);
			if (2 == i || 5 == i) {
				toolBar.addSeparator();
			}
			
		}
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Pure JFC", JLabel.CENTER);
		
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 40));
		label.setOpaque(true);
		panel.add(label);
		
		c.add(toolBar, BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(posX, posY, WINDOW_WIDTH, WINDOW_HEIGHT);
		this.pack();
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new TestToolTip();
	}

}
















































































































































































































































































































































