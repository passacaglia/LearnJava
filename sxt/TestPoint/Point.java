public class Point {
	public double x;
	public double y;
	public double z;
	
	public Point(double _x, double _y, double _z) {
		x = _x;
		y = _y;
		z = _z;
	}
	
	public void setPointX(double _x) {
		this.x = _x;
	}
	
	public void setPointY(double _y) {
		y = _y;
	}
	
	public void setPointZ(double _z) {
		z = _z;
	}
	
	public double lengthL(Point p) {
		/*double ll;
		ll = x*x + y*y + z*z;
    return ll;*/
    
    //计算 调用lengthL方法的点 到p点 距离的平方
    return (x - p.x)*(x - p.x) + (y - p.y)*(y-p.y) + (z - p.z)*(z - p.z);
    }
}