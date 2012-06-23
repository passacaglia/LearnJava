
import java.awt.*;
import javax.swing.*;


class TestToolTip_A extends JFrame {

	private static final int WINDOW_WIDTH = 300, WINDOW_HEIGHT = 200;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static final int POS_X = (int)(tk.getScreenSize().getWidth()/2 - WINDOW_WIDTH*4/5);
	private static final int POS_Y = (int)(tk.getScreenSize().getHeight()/2 - WINDOW_HEIGHT*7/8);

	Icon newIcon = new ImageIcon(TestToolTip_A.class.getClassLoader().getResource("img/new.gif"));
	Icon openIcon = new ImageIcon(TestToolTip_A.class.getClassLoader().getResource("img/open.gif"));
	Icon saveIcon = new ImageIcon(TestToolTip_A.class.getClassLoader().getResource("img/save.gif"));
	Icon cutIcon = new ImageIcon(TestToolTip_A.class.getClassLoader().getResource("img/cut.gif"));
	Icon copyIcon = new ImageIcon(TestToolTip_A.class.getClassLoader().getResource("img/copy.gif"));
	Icon pasteIcon = new ImageIcon(TestToolTip_A.class.getClassLoader().getResource("img/paste.gif"));
	
	Icon[] icons = { newIcon, openIcon, saveIcon,
					 cutIcon, copyIcon, pasteIcon };
	
	String[] iconNames = {"New", "Open", "Save", 
						  "Cut", "Copy", "Paste"};
	
	JButton jb = null;
	
	
	TestToolTip_A() {
		
		Container c = this.getContentPane();
		
		//toolbar
		JToolBar jt = new JToolBar();
		jt.setMargin(new Insets(5, 5, 5, 5));
		
		for (int i=0; i<icons.length; i++) {
			jb = new JButton(icons[i]);
			jb.setToolTipText(iconNames[i]);
			jt.add(jb);
			if (2 == i || 5 == i) {
				jt.addSeparator();
			}
		}
		
		//panel
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("PURE JFC");
		
		
		c.add(jt, BorderLayout.CENTER);
		c.add(jp, BorderLayout.SOUTH);
		
		this.setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new TestToolTip_A();
	}

}





































































































































































































































































































































































































































































































































