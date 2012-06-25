/**
 * Things you need to change.
 * 0. property : smtp server
 * 1. username & passwd
 * 2. send from
 * 3. reply to (if you want)
 * 
 */

package com.az.javabean;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Email {

	public void send(HashMap<String, String> recipients, String subject,
			String emailCont) {

		try {
			// session " environment prepare
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.SMTP_SERVER.com");
			props.setProperty("mail.debug", "true");
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					// replace with xxx
					return new PasswordAuthentication("YOUR_USER_NAME",
							"YOUR_PASSWORD");
				}
			});

			// Here is the message.
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("YOUR_NICK")
					+ "\"" + "<YOUR_EMAIL_ADDRESS>"));
			msg.setSubject(subject);
			msg.setReplyTo(new Address[] { new InternetAddress(
					"EMAIL_THAT_YOU_WANT_HE_TO_REPLY") });

			// this way to show the friendly name: "friendly username"(space
			// then with"<>")<the email address>
			msg.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(this.recipients(recipients)));

			// Here "mixed" is a subtype. So "multipart/mixed" is not needed.
			MimeMultipart mmp = new MimeMultipart("mixed");
			msg.setText(emailCont);

			// save & send
			msg.saveChanges();
			//Transport.send(msg, InternetAddress.parse("the@email.address"));
			Transport.send(msg);

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public String recipients(HashMap<String, String> recipients) {
		StringBuffer sb = new StringBuffer();
		String s = "";
		
		try {
			for (Map.Entry<String, String> entry : recipients.entrySet()) {

				s = MimeUtility.encodeText(entry.getKey()) + " <"
						+ entry.getValue() + ">";
				sb.append(", " + s);
				//System.out.println(sb.toString());							
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String recp = sb.toString();
		
		return recp;
	}

}
