

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session_URL
 */
@WebServlet("/Session_URL")
public class Session_URL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session_URL() {
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
				pw.println("<a href=" + response.encodeURL(request.getRequestURL().toString()) + "> refresh</a>");
				
				pw.println("</body></html>");
				
				pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}





















