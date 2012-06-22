import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


class TestWindowBuilder extends JFrame {
	
	private static final int WINDOW_WIDTH = 300, WINDOW_HEIGHT = 200;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static final int POS_X = (int)(tk.getScreenSize().getWidth()/2 - WINDOW_WIDTH*4/5);
	private static final int POS_Y = (int)(tk.getScreenSize().getHeight()/2 - WINDOW_HEIGHT*7/8);
	
	
	public TestWindowBuilder() {
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSaveAsPng = new JMenuItem("Save As PNG");
		mnFile.add(mntmSaveAsPng);
		
		JMenuItem mntmSaveAsWad = new JMenuItem("Save As WAD");
		mnFile.add(mntmSaveAsWad);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpContent = new JMenuItem("Help Content");
		mnHelp.add(mntmHelpContent);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestWindowBuilder();
	}
}
