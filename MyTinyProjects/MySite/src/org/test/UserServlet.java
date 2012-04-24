package org.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.test.javabean.UserBean;

public class UserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = (String)request.getParameter("method");
		if(null == method) {
			PrintWriter out = response.getWriter();
			out.println("invalid request!");
		} else if(method.equals("login")) {
			login(request, response);
		} else if(method.equals("logout")) {
			logout(request, response);
		} else if(method.equals("register")) {
			register(request, response);
		}
	}

	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// check null
		if (null == username || null == password) {
			response.sendRedirect("login.jsp?error=1");
			return;
		}

		// validate
		UserBean userBean = new UserBean();
		boolean isValid = userBean.valid(username, password);

		if (isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
			return;
		} else {
			response.sendRedirect("login.jsp?error=1");
			return;
		}
	}

	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("login.jsp");
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get parameters
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");

		// check null
		if (username == null || password1 == null || password2 == null || !password1.equals(password2)) {
			response.sendRedirect("register.jsp");
			return;
		}

		// validate
		UserBean userBean = new UserBean();
		boolean isExist = userBean.isExist(username);
		if(!isExist) {
			userBean.add(username, password1, email);
			response.sendRedirect("login.jsp");
			return;
		} else {
			response.sendRedirect("register.jsp");
			return;
		}
	}

}