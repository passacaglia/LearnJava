/**
*Ӧ�þ���ʹ�����ַ���������Frame�����ַ���������MyFrame���涨���Լ������Ա������
****/

import java.awt.*;

public class TestMultiFrame {
	public static void main(String[] args) throws Exception{
		MyFrame mf1 = new MyFrame(100, 100, 320, 180, Color.RED);
		MyFrame mf2 = new MyFrame(420, 100, 320, 180, Color.YELLOW);
		MyFrame mf3 = new MyFrame(100, 280, 320, 180, Color.GREEN);
		MyFrame mf4 = new MyFrame(420, 280, 320, 180, Color.BLUE);
	}
}


class MyFrame extends Frame {
	
	static int id = 0;
	
	MyFrame(int x, int y, int w, int h, Color color) {
		super("My Frame " + (++id));
		setVisible(true);
		setLayout(null);
		setBounds(x, y, w, h);
		setBackground(color);
	}

}