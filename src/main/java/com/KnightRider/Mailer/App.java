package com.KnightRider.Mailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;

public class App {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        sendEmail();
    }

    public static void sendEmail() {
        LOGGER.info("about to Send mail..");
        try {
            new Mailer().sendMail();
        } catch (MessagingException e) {
            LOGGER.error("Something went wrong while sending mail :( ", e);
        }
        LOGGER.info("Mail sent Successfully...");
    }
}
