

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Session_Counter
 */
@WebServlet("/Session_Counter")
public class Session_Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=gb2312");
		
		HttpSession hs = request.getSession();
		Integer count = (Integer)hs.getAttribute("count");
		String heading;
		if (null == count) {
			count = new Integer(0);
			heading = "Hello, Amigo!";
		} else {
			count = new Integer(count.intValue() + 1);
			heading = "Welcome back, amigo!";
		}
		hs.setAttribute("count", count);
		
		
		
		PrintWriter pw = response.getWriter();
		pw.println("<html> <head> <title> Session _ Counter </title> </head> <body> <center>");
		pw.println("<h1 > " + heading + "</h1> <br />");
		pw.println("<h2> " + count + "</h2>");
		pw.println(" </center> </body> </html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
