
class Circle {
    private Point o;
    private double radius;
    Circle(Point p, double r) {
    	o = p; 
    	radius = r;
    }
    Circle(double r) {
        o = new Point(0.0, 0.0);
        radius = r;
    }
    
    boolean contains(Point p) {
    	double x = p.getX() - o.getX();
    	double y = p.getY() - o.getY();
    	if(x*x + y*y > radius * radius) return false;
    	else return true;
    }
    
    
    public void setO(double x, double y) {
        o.setX(x); 
        o.setY(y);
    }
    public Point getO() { return o; }
    public double getRadius() { return radius;}
    public void setRadius(double r) { radius = r;}
    public double area() { 
        return 3.14 * radius * radius;
    }
}
