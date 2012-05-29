/**
 * Send an email in a different way.
 */

package com.az.javamail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test2 {

	public static void main(String[] args) throws Exception {
		//session " environment prepare
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.THE_SERVER.com");
		props.setProperty("mail.debug", "true");
		Session session = Session.getInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//replace with xxx
						return new PasswordAuthentication("YOUR_USERNAME", "YOUR_PASSWORD");
					}
				} );
		
		//message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("your@email.address"));
		msg.setRecipients(Message.RecipientType.TO, 
						 InternetAddress.parse("who@receive.this"));
		msg.setContent("<font color=red>Hello, how are you?</font>", "text/html;charset=utf8");
		
		
		//transport
		Transport.send(msg);
	}

}
