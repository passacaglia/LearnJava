

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletLifeCircle extends HttpServlet {

	public ServletLifeCircle() {
		System.out.println("Constructor");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destory");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		PrintWriter pw = new PrintWriter(new DataOutputStream(response.getOutputStream()));
		pw.write("<font color='red'>Hello, response.</font>");
		pw.flush();
		pw.close();
	}
	
}
