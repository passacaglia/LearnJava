


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestParameters
 */
@WebServlet("/TestParameters")
public class TestParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestParameters() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = new PrintWriter(new DataOutputStream(response.getOutputStream()));
		pw.println(request.getParameter("p1"));
		pw.println("<br />");
		pw.println(request.getParameter("p2"));
		pw.println("<br />");
		pw.println(request.getParameter("p3"));
		pw.println("<br />");
		pw.flush();
		pw.close();
		System.out.println("hi");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}










































































































































































































































































































































































