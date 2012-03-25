
import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Vector;

import com.sun.java.swing.plaf.windows.*;

class TestJLayeredPane_A extends JFrame implements ActionListener {

	JButton jb = null;
	JPanel jp = null;
	JLayeredPane layeredPane = null;
	
	static int frameCount = 0;
	static final int xOffSet = 25;
	static final int yOffSet = 25;
	
	Integer[] layerConstants = { JLayeredPane.DEFAULT_LAYER,
								 JLayeredPane.PALETTE_LAYER,
								 JLayeredPane.MODAL_LAYER,
								 JLayeredPane.POPUP_LAYER,
								 JLayeredPane.DRAG_LAYER,
								};
	
	String[] layerNames = { "Default Layer",
							"Palette Layer",
							"Modal Layer",
							"Popup Layer",
							"Drag Layer"
						   };
	
	
	Vector<JInternalFrame> framesVector = new Vector<JInternalFrame>();
	
	
	
	TestJLayeredPane_A() {
		Container c = this.getContentPane();
		
		//panel
		jp = new JPanel(new GridLayout(3, 3));
		jp.setBorder(BorderFactory.createTitledBorder("Click to create or clear internal frames"));
		jp.setSize(200, 50);
		c.add(jp, BorderLayout.SOUTH);
		
		//buttons
		for (int i=0; i<layerNames.length+1; i++) {
			if (i < layerNames.length) {
				jb = new JButton("Add \" " + layerNames[i] + " \" ");
				jb.setActionCommand(layerNames[i]);
			} else {
				jb = new JButton("Clear all of the internal frames");
				jb.setActionCommand("Clear");
				jb.setForeground(Color.RED);
			}
			
			jb.addActionListener(this);
			jp.add(jb);
		}
		
		//frame
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		String laf = UIManager.getSystemLookAndFeelClassName();
		//MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		final String windows  =
	            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			//UIManager.setLookAndFeel(new MetalLookAndFeel());
			UIManager.setLookAndFeel(windows);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle(laf);
		this.setBounds(350, 100, 500, 300);
		this.setVisible(true);
		
		//layered pane
		layeredPane = this.getLayeredPane();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton)e.getSource();
		
		if (layerNames[0] == temp.getActionCommand()) {
			addInternalFrame(0);
		} else if (layerNames[1] == temp.getActionCommand()) {
			addInternalFrame(1);
		} else if (layerNames[2] == temp.getActionCommand()) {
			addInternalFrame(2);
		} else if (layerNames[3] == temp.getActionCommand()) {
			addInternalFrame(3);
		} else if (layerNames[4] == temp.getActionCommand()) {
			addInternalFrame(4);
		} else {
			for (Enumeration<JInternalFrame> e1 = framesVector.elements(); e1.hasMoreElements();) {
				((JInternalFrame)e1.nextElement()).dispose();
			}
		}
	}

	
	void addInternalFrame(int index) {
		JInternalFrame iFrame = new JInternalFrame(layerNames[index], true, true, true, true);
		
		framesVector.addElement(iFrame);
		
		
		iFrame.setLocation(xOffSet*frameCount, yOffSet*frameCount++);
		iFrame.setDefaultCloseOperation(iFrame.EXIT_ON_CLOSE);
		iFrame.setSize(200, 100);
		iFrame.show();
		
		layeredPane.add(iFrame);
	}
	
	
	public static void main(String[] args) {
		new TestJLayeredPane_A();
	}

}








































































































































































































































































