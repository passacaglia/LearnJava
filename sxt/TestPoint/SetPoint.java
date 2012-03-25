public class SetPoint {
	
	public static void main(String args[]) {
		Point p1 = new Point(3,7,4);
		System.out.println("\np1:" + "(" + p1.x + "," + p1.y + "," + p1.z + ")");
		
		p1.setPointX(4);
		p1.setPointY(8);
		p1.setPointZ(5);
		System.out.println("\nAfter set..." + "\np1:" + "(" + p1.x + "," + p1.y + "," + p1.z + ")");
		
//计算p1到原点之间的距离平方
		System.out.println("\np1到原点之间的距离之平方:\n" + p1.lengthL(new Point(0.0,0.0,0.0)));//直接new出一个对象实例，只不过这个实例没有名字
	}
}