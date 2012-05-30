/**
 * Send an email in a different way.
 */

package com.az.javamail;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test4SendEmailFile {

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
		FileInputStream fis = new FileInputStream("resource/MyFirstEmail.eml");
		Message msg = new MimeMessage(session, fis);
		fis.close();
		
		//transport
		Transport.send(msg, InternetAddress.parse("the@email.address"));
	}

}




















