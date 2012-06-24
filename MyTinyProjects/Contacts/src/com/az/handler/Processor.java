package com.az.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.az.javabean.DBAccess;

/**
 * Servlet implementation class Processor
 */
@WebServlet("/do.it")
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBAccess dba = null;
    private String sql = null;
    private String dowhat = null;
    private String name = null;
    private String email = null;
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
		request.setCharacterEncoding("utf8");
		
		dowhat = request.getParameter("dowhat");
		p = response.getWriter();
		
		if (dowhat.equals("insert")) {
			name = request.getParameter("name");
			email = request.getParameter("email");
			
			if ((null != name) && !name.equals("")) {
				if ((null != email && !email.equals("")) && isEmail(email)) {
					insertDT(name, email);
					p.write("insert!");
				}
			}
		} else if (dowhat.equals("read")) {
			readDT();
			p.write("read!");
		}
		
		
		dowhat = null;
		name = null;
		email = null;
		
		
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
	
	private boolean readDT() {
		dba = new DBAccess();
		sql = "select * from contacts"; 
		dba.createConn();
		dba.query(sql);
		
		while (dba.next()) {
			System.out.println(dba.getName());
			System.out.println(dba.getEmail());
		}
		
		dba.closeStmt();
		dba.closeConn();
		
		System.out.println("insert");
		
		dba = null;
		sql = null;
		
		return false;
	}
	
	
}

















