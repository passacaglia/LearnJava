

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext_Counter
 */
@WebServlet("/ServletContext_Counter")
public class ServletContext_Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContext_Counter() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		
		response.setContentType("text/html; charst=gb2312");
		
		Integer count = (Integer) sc.getAttribute("count");
		if (null == count) {
			count = new Integer(0);
		} else {
			count = new Integer(count.intValue() + 1);
		}
		sc.setAttribute("count", count);
		
		
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html> <head> <title> SessionContext Counter </title> </head> <body>");
		pw.println("<h3> You are the " + count.intValue() + "(th)  visitor </h3>");
		
		pw.println("</body></html>");
		
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

























