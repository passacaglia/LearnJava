

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Cookie_Set
 */
@WebServlet("/Cookie_Set")
public class Cookie_Set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie_Set() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//new Cookie
		Cookie c = null;
		for (int i=0; i<6; i++) {
			// Default maxAge is -1, indicating cookie applies only to current browsing session.
			c = new Cookie("Session-Cookie-" + i, "Cookie-Value-" + i);
        	response.addCookie(c);
        	
        	c = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P-" +i);
        	// Cookie is valid for an hour, regardless of whether user quits browser, reboots computer, or whatever.
        	c.setMaxAge(3600);
        	response.addCookie(c);
        }
		
		
		//response content
		response.setContentType("text/html; charset=gb2312");

		PrintWriter pw = response.getWriter();
		
		pw.println("<html> <head> <title> Cookie _ Set </title> </head> \n");
		pw.println("<body> <center> 6 cookies have been set, <br />" 
				   + "3 session-cookies which will expire when the browser window close, <br />"
				   + "3 persistent-cookies which need to be deleted by hand.  <br />"
				   + "<a href=\"Cookie_Show\">Show the Cookies</a>	" 
				   + "</body>");
		pw.println("</html>");
		
		
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}




















































































