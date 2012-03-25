

import java.io.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Session_Cookie
 */
@WebServlet("/Session_Cookie")
public class Session_Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session_Cookie() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get current session or, if necessary, create a new one
		HttpSession mySession = request.getSession(true);
		
		//response
		response.setContentType("text/html; charset=gb2312");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html> <head> <title> Session (using cookie) </title> </head> <body>");
		pw.println("<h3> Session Information </h3>");
		pw.println("New Session ? : " + mySession.isNew() );
		pw.println("<br /> Session ID : " + mySession.getId());
		pw.println("<br /> Session Creation Time : " + new Date(mySession.getCreationTime()));
		pw.println("<br /> Session Last Accessed Time : " + new Date(mySession.getLastAccessedTime()));
		
		pw.println("<h3>Request Information </h3>" );
		pw.println("Session ID from Request: " +
			        request.getRequestedSessionId());
	    pw.println("<BR>Session ID via Cookie: " +
		    	    request.isRequestedSessionIdFromCookie());
		pw.println("<BR>Session ID via rewritten URL: " +
			    	request.isRequestedSessionIdFromURL());
		pw.println("<BR>Valid Session ID: " +
					request.isRequestedSessionIdValid());
		
		pw.println("</body></html>");
		
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}























































