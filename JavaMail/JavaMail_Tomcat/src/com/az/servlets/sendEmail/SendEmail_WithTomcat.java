/**
 * When you use this program.You should put "mail.jar" into the folder "<tomcat>/lib". 
 */

package com.az.servlets.sendEmail;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmail_WithTomcat
 */
@WebServlet("/SendEmail_WithTomcat")
public class SendEmail_WithTomcat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail_WithTomcat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		response.getWriter().println("doGet_SendEmail_WithTomcat");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			Session session = (Session) envCtx.lookup("mail/Dog");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("YOUR@EAMIL.ADDRESS"));
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress("HIS@EMAIL.ADDRESS");
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("send mail with tomcat");
			message.setContent("Hello, how are you?", "text/plain");
			//Transport.send(message);
			Transport transport = session.getTransport();
			transport.connect("smtp.YOUR_HOST.com","YOUR_USERNAME", "YOUR_PASSWORD");
			transport.sendMessage(message, to);
			transport.close();
			response.getWriter().println("SendEmail_WithTomcat_ok!");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	}

}

















