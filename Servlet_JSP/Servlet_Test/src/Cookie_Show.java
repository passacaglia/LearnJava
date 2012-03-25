

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Cookie_Show
 */
@WebServlet("/Cookie_Show")
public class Cookie_Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie_Show() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=gb2312");
		pw.println("<html> <head> <title> Cookie _ Show </title> </head> \n");
		pw.println("<body BGCOLOR=\"#FDF5E6\"> <center> <h1> Active Cookie(s) </h1> ");
		pw.println("<table> <tr bgcolor=\"orange\"> <th>Cookie Name</th> <th>Cookie Value</th> </tr>");
		
		Cookie[] cookie = request.getCookies();
		
		if (cookie != null) {
			for (int i=0; i<cookie.length; i++) {
				pw.println("<tr>");
				pw.println("<td>" + cookie[i].getName() + "</td>");
				pw.println("<td>" + cookie[i].getValue() + "</td>");
				pw.println("</tr>");
			}
		}
		
		
		
		pw.println(" \n </table> </center> </body> </html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
























































































































































































































































































