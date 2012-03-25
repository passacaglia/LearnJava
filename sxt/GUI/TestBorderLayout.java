//

import java.awt.*;

public class TestBorderLayout {
	public static void main(String[] args) {
		Frame f = new Frame("Border Layout");
		
		Button bn = new Button("BN");
		Button bs = new Button("BS");
		Button bw = new Button("BW");
		Button be = new Button("BE");
		Button bc = new Button("BC");
		
		/*
		*一定不要用这种方法添加button。做不到问题的早暴露。
		*如果字符出不小心写错的话。
		f.add(bn, "North");
		f.add(bs, "South");
		f.add(bw, "West");
		f.add(be, "East");
		f.add(bc, "Center");
		*/
		
		//推荐这种方式。
		f.add(bn, BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.EAST);
		f.add(bc, BorderLayout.CENTER);
		
		f.setSize(200, 200);
		f.setVisible(true);
	}
}