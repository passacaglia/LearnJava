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
			props.setProperty("mail.host", "smtp.THE_SERVER.com");
			props.setProperty("mail.debug", "true");
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					// replace with xxx
					return new PasswordAuthentication("YOUR_USERNAME",
							"YOUR_PASSWORD");
				}
			});

			// Here is the message.
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("ÕÅÈý")
					+ "\"" + "<your@address.com>"));
			msg.setSubject(subject);
			msg.setReplyTo(new Address[] { new InternetAddress(
					"theAddress@you.want") });

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

	private String recipients(HashMap<String, String> recipients) {
		StringBuffer sb = new StringBuffer();
		String s = "";

		try {
			for (Map.Entry<String, String> entry : recipients.entrySet()) {

				s = MimeUtility.encodeText(entry.getKey()) + " <"
						+ entry.getValue() + ">,";
			}
			sb.append(s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		s = sb.toString();
		s = s.substring(0, (s.length()-2));//remove the last ",".
		
		return s;
	}

}
