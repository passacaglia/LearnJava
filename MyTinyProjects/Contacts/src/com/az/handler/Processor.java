package com.az.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.az.javabean.Contacts;
import com.az.javabean.DBAccess;
import com.az.javabean.Email;

/**
 * Servlet implementation class Processor
 */
@WebServlet("/do.it")
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBAccess dba = null;
    private Email theEmail = null;
    private String sql = null;
    private String dowhat = null;
    private String name = null;
    private String email = null;
    private String subject = null;
    private String emailCont = null;
    PrintWriter p = null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Processor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//important for Chinese
		request.setCharacterEncoding("utf8");
		
		dowhat = request.getParameter("dowhat");
		p = response.getWriter();
		
		
		//choice
		if (dowhat.equals("insert")) {
			name = request.getParameter("name");
			email = request.getParameter("email");
			
			if ((null != name) && !name.equals("")) {
				if ((null != email && !email.equals("")) && isEmail(email)) {
					insertDT(name, email);
					p.write("insert!");
				}
			}
		} else if (dowhat.equals("send")) {
			subject = request.getParameter("subject");
			emailCont = request.getParameter("emailCont");
			sendEmail(new Contacts().getContacts(), subject, emailCont);
			p.write("sent!");
		}
		
		
		//save resource 
		dowhat = null;
		name = null;
		email = null;
		subject = null;
		emailCont = null;
		
	}

	private boolean isEmail(String email) {
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(email);
//System.out.println(m.matches());
		return m.matches();
				
	}
	
	private boolean insertDT(String name, String email) {
		dba = new DBAccess();
		sql = "insert into contacts values (null, '" + name + "', '" + email + "')"; 
		dba.createConn();
		dba.update(sql);
		
		dba.closeStmt();
		dba.closeConn();
		
		System.out.println("insert");
		
		dba = null;
		sql = null;
		return false;
	}
	
	private boolean sendEmail(HashMap<String, String> recipients, String subject, String emailCont) {
		theEmail = new Email();
		theEmail.send(recipients, subject, emailCont);
		
		return false;
	}
	
	
}

















