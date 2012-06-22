public class ExShowDate extends java.applet.Applet {
	
	java.util.Date date = new java.util.Date();
	String time = date.toString();
	
	public void init() {
		
	}
	
	public void paint(java.awt.Graphics g) {
		g.drawString("Current time : " + this.time,30,30);
	}
}