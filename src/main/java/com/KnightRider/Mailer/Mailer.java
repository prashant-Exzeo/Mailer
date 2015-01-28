package com.KnightRider.Mailer;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailer {

	String smtpHost = "relay"; // Mail Server
	String smtpPort = "2525"; // Port
	// String smtpAuth = "true";
	String smtpStarttlsEnable = "true";
	String mailUser = "prashantk@exz.com";
	String toAddress = "prashantk@exz.com";

	private Multipart addAttachment(Multipart multipart, String filename)
			throws MessagingException {
		DataSource source = new FileDataSource(filename);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);
		return multipart;
	}

	public void sendMail() throws AddressException, MessagingException {

		String filename = "/home/prashant/Desktop/gitCommands";
		// Get system properties
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", smtpHost);
		properties.setProperty("mail.smtp.port", smtpPort); // TLS Port
		properties.setProperty("mail.smtp.starttls.enable", smtpStarttlsEnable); // enable
		// STARTTLS
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mailUser));

		// Set To: header field of the header.
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				toAddress));

		// Set Subject: header field
		message.setSubject("This is the Subject Line!");

		// Now set the actual message
		message.setText("This is actual message");

		message.setContent(addAttachment(new MimeMultipart(), filename));
		// Send message
		Transport.send(message);
	}
}
