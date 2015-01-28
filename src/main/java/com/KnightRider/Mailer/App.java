package com.KnightRider.Mailer;

import javax.mail.MessagingException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("about to Send mail..");

		try {
			new Mailer().sendMail();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Mail sent Successfully...");
	}
}
