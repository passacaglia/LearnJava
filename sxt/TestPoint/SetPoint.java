public class SetPoint {
	
	public static void main(String args[]) {
		Point p1 = new Point(3,7,4);
		System.out.println("\np1:" + "(" + p1.x + "," + p1.y + "," + p1.z + ")");
		
		p1.setPointX(4);
		p1.setPointY(8);
		p1.setPointZ(5);
		System.out.println("\nAfter set..." + "\np1:" + "(" + p1.x + "," + p1.y + "," + p1.z + ")");
		
//����p1��ԭ��֮��ľ���ƽ��
		System.out.println("\np1��ԭ��֮��ľ���֮ƽ��:\n" + p1.lengthL(new Point(0.0,0.0,0.0)));//ֱ��new��һ������ʵ����ֻ�������ʵ��û������
	}
}