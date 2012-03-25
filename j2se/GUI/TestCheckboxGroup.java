/**
*一个CheckboxGroup里面可以有多个   Checkbox。但是只能有一个被选中。
*
*cb[0],cb[1]属于cbg1，同时只能选中一个。
*
*cb[2],cb[3]属于cbg2，同时也只能选中一个。
*
*cbg1和cbg2之间不影响。
**/


import java.awt.*;
import java.awt.event.*;

public class TestCheckboxGroup extends Frame{
	
	Checkbox[] cb = new Checkbox[4];
	CheckboxGroup cbg1, cbg2;
	Label label1, label2;
	
	//ItemMonitor
	ItemMonitor im = new ItemMonitor();
	Checkbox cbM = null;
	CheckboxGroup cbgM = null;
	
	public static void main(String[] args) {
		new TestCheckboxGroup().launch();
	}
	
	public void launch() {
		setBounds(300, 200, 400, 300);
		setLayout(new GridLayout(6, 1));
		
		label1 = new Label();
		label2 = new Label();
		
		cbg1 = new CheckboxGroup();
		cbg2 = new CheckboxGroup();
		
		//cbg1
		cb[0] = new Checkbox("Item 1");
		cb[1] = new Checkbox("Item 2");
		cb[0].setCheckboxGroup(cbg1);
		cb[1].setCheckboxGroup(cbg1);
		
		//cbg2
		cb[2] = new Checkbox("Item 3", cbg2, true);//true,selected
		//下面这个本来是要设false的，现在设成true，会把前面的覆盖掉
		cb[3] = new Checkbox("Item 4", cbg2, true);
		
		for (int i=0; i<4; i++) {
			cb[i].addItemListener(im);
		}
		
		add(cb[0]);
		add(cb[1]);
		add(label1);//添加个空
		add(cb[2]);
		add(cb[3]);
		add(label2);
		pack();
		setVisible(true);
	}
	
	private class ItemMonitor implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			cbM = (Checkbox)e.getSource();
			cbgM = cbM.getCheckboxGroup();
			if (cbgM.equals(cbg1)) {
				label1.setText(cbM.getLabel() + " selected.");
			} else {
				label2.setText(cbM.getLabel() + " selected.");
			}
						
		}
	}
	
	
}