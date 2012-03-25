public class GetParamApplet extends java.applet.Applet {
	public void init() {
		System.out.println("Parameter P1 =" + getParameter("P1"));
		System.out.println("Parameter P2 =" + getParameter("P2"));
	}
}