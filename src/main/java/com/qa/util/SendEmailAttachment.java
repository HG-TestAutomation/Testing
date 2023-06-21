package com.qa.util;



	import java.io.File;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.util.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;

import com.sun.mail.smtp.SMTPTransport;


import com.qa.factory.DriverFactory;

	public class SendEmailAttachment {

	    public DriverFactory driverfactory;
	    public static Properties configProperties;

	    // for example, smtp.mailgun.org
	    private static final String SMTP_SERVER = "smtp.gsa.gov";
	    private static final String USERNAME = "";
	    private static final String PASSWORD = "";

	    private static final String EMAIL_SUBJECT = "Automation Test Report";
	    private static final String EMAIL_TEXT = " Team, \n\n The automation test execution has been completed. "
	            + "Please see the attachment for detailed results. \n\n Thanks, \n Test Team.";


	    public static void main(String[] args) {

	        Properties prop = System.getProperties();
	        prop.put("mail.smtp.auth", "true");

	        Session session = Session.getInstance(prop, null);
	        Message msg = new MimeMessage(session);

	        try {

	            configProperties = ConfigReader.loadConfigProperties();
	            String emailFrom = StringUtils.firstNonBlank(System.getenv("tf_email_from"), configProperties.getProperty("emailFrom"));
	            msg.setFrom(new InternetAddress(emailFrom));

	            String emailTo = StringUtils.firstNonBlank(System.getenv("tf_email_to"), configProperties.getProperty("emailTo"));
	            msg.setRecipients(Message.RecipientType.TO, new Address[]{new InternetAddress(emailTo)});

	            msg.setSubject(EMAIL_SUBJECT);

	            // text
	            MimeBodyPart p1 = new MimeBodyPart();
	            p1.setText(EMAIL_TEXT);
	            Properties extentProperties = ConfigReader.loadExtentProperties();
	            String pdfPath =  extentProperties.getProperty("extent.reporter.pdf.out");

	            Multipart mp = new MimeMultipart();
	            mp.addBodyPart(p1);
	            if (Files.exists(Paths.get(pdfPath))) {
	                File mostRecent = new File(pdfPath);
	                FileDataSource fds = new FileDataSource(mostRecent);
	                MimeBodyPart p2 = new MimeBodyPart();
	                p2.setDataHandler(new DataHandler(fds));
	                p2.setFileName(fds.getName());
	                mp.addBodyPart(p2);
	            } else {
	                System.out.println("Report not found at path: " + pdfPath);
	            }

	            msg.setContent(mp);

	            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

	            // connect
	            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

	            // send
	            t.sendMessage(msg, msg.getAllRecipients());

	            System.out.println("Response: " + t.getLastServerResponse());

	            t.close();

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }

	    }

	}



