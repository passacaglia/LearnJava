/**
 * Create an email with java. And then, write it into a file.(Message)
 */

package com.az.javamail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Test3 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Session session = Session.getInstance(new Properties());//Just create an email, so no more properties needed.
		
		//Here is the message.
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("张三") + "\"" + "your@address.com"));
		msg.setSubject("Say hello.你好吗？");
		msg.setReplyTo(new Address[]{new InternetAddress("theAddress@you.want")});
		//this way to show the friendly name: "friendly username"(space then with"<>")<the email address>
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MimeUtility.encodeText("友好名称") + " <tom@jerry.com>," + MimeUtility.encodeText("友好") + " <jerry@tom.com>"));
		MimeMultipart mmp = new MimeMultipart("mixed");//Here "mixed" is a subtype. So "multipart/mixed" is not needed.
		msg.setContent(mmp);
		
		//the message content. parts. new & add. 
		MimeBodyPart attch1 = new MimeBodyPart();
		MimeBodyPart attch2 = new MimeBodyPart();
		MimeBodyPart content = new MimeBodyPart();
		mmp.addBodyPart(attch1);
		mmp.addBodyPart(attch2);
		mmp.addBodyPart(content);
		
		//1. attach1
		DataSource ds1 = new FileDataSource("resource/attach1.png");
		DataHandler dh1 = new DataHandler(ds1);
		attch1.setDataHandler(dh1);
		attch1.setFileName(
				MimeUtility.encodeText("附件1.png")
				);
		
		//2. attach2
		DataSource ds2 = new FileDataSource("resource/attach2.txt");
		DataHandler dh2 = new DataHandler(ds2);
		attch2.setDataHandler(dh2);
		attch2.setFileName("attach2.txt");
		
		//3. content
		//content is also a multipart one.
		MimeMultipart bodyMmp = new MimeMultipart("related");
		content.setContent(bodyMmp);
		
		//3.0 parts
		MimeBodyPart content_html = new MimeBodyPart();
		MimeBodyPart content_gif = new MimeBodyPart();
		bodyMmp.addBodyPart(content_html);
		bodyMmp.addBodyPart(content_gif);
		
		//3.1 content_html
		content_html.setContent("<font color=red>Hello, this is my 第一封邮件</font>", "text/html;charset=utf8");
		
		//3.2 content_gif
		DataSource ds_gif = new FileDataSource("resource/chou.gif");
		DataHandler dh_gif = new DataHandler(ds_gif);
		content_gif.setDataHandler(dh_gif);
		//?question here.
		content_gif.setHeader("Content-Location", "resource/chou.gif");
		
		msg.saveChanges();
		
		FileOutputStream fos = new FileOutputStream("resource/MyFirstEmail.eml");
		msg.writeTo(fos);
		fos.close();
		System.out.println("ok!");
	}

}
















