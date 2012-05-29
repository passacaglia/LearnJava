/**
 * Send an email.
 */

package com.az.javamail;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		msg.setText("Amigo!");
		msg.setFrom(new InternetAddress("your@email.address"));
		
		Transport transport = session.getTransport();
		//change the passwd when you commit.
		transport.connect("smtp.THE_SERVER.com", 25, "USERNAME", "PASSWORD");
		transport.sendMessage(msg, new Address[]{new InternetAddress("his@email.address")});
		transport.close();
	}

}












