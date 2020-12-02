package Pharmacy;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	public void sendUser(String email, String path) {// authentication info
		final String username = "pharmacyvce@gmail.com";
		final String password = "java2020";
		String fromEmail = "pharmacyvce@gmail.com";
		String toEmail = email;

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Hello User! Here is your receipt for the purchase at our Pharmacy!");

			Multipart emailContent = new MimeMultipart();

			// Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("INVOICE");

			// Attachment body part.
			MimeBodyPart Attachment = new MimeBodyPart();
			Attachment.attachFile(path);

			// Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(Attachment);

			// Attach multipart to message
			msg.setContent(emailContent);

			Transport.send(msg);
			// System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}