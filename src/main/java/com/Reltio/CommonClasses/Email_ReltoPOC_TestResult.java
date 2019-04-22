package com.Reltio.CommonClasses;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


public class Email_ReltoPOC_TestResult
{
	//To send email to the given users in the property file (Call the SMTP host, port no.)
	public static void execute() throws Exception
	{
		 Read_PropertyFile configEmail=new Read_PropertyFile();


			String path=System.getProperty("user.dir")+"/test-output/Reltio_ExtentReport.html";
			String[] to={configEmail.getTo_Email()};
			String[] cc={};
			String[] bcc={configEmail.getBCC()};


			Email_ReltoPOC_TestResult.sendMail(configEmail.from_Email(),configEmail.getMyPassword(),configEmail.gethostno(),configEmail.getport(),"true","true",false,"javax.net.ssl.SSLSocketFactory","true",to,cc,bcc,"Extent Report for Reltio",
			"Hi,Please find the attachment",path,"Reltio_ExtentReport.html");
		
		
	 
	}

	// Setting the email Subject, body, extent report attachment
	public static boolean sendMail(String userName,String passWord,String host,String port,String starttls,String auth,boolean debug,String socketFactoryClass,String fallback,String[] to,String[] cc,
	String[] bcc,String subject,String text,String attachmentPath,String attachmentName)
	{
		
	//Object Instantiation of a properties file.
	Properties props = new Properties();

	try{
		
	Session session = Session.getDefaultInstance(props, null);

	session.setDebug(debug);

	//Create a default MimeMessage object.
	MimeMessage msg = new MimeMessage(session);

	// Set Subject: header field
	msg.setSubject(subject);


	//Create a multipar message
	Multipart multipart = new MimeMultipart();  

	// Create the first message part 
	MimeBodyPart messageBodyPart = new MimeBodyPart();
	//message body
	messageBodyPart.setText("Hi Team,\n\tPlease find the attached Extent Report for Reltio.\n\nThanks & Regards,\nV-Soft Consulting");
	//Set text message part
	multipart.addBodyPart(messageBodyPart);

	//Part two is attachment
	messageBodyPart = new MimeBodyPart();
	//Thread.sleep(50000);
	DataSource source = new FileDataSource(attachmentPath);
	messageBodyPart.setDataHandler(new DataHandler(source));
	messageBodyPart.setFileName(attachmentName);
	//adding attachment also to multipart
	multipart.addBodyPart(messageBodyPart);


	//Sending the complete message parts to MimeMessage
	msg.setContent(multipart);

	msg.setFrom(new InternetAddress(userName));
	//msg.setText("Hi,\n\tPlease find the attached Extent Report for Oklahoma.\nThanks & Regards,\nSwethana Inampudi.");
	for(int i=0;i<to.length;i++){
	msg.addRecipient(Message.RecipientType.TO, new
	InternetAddress(to[i]));
	}

	for(int i=0;i<cc.length;i++){
	msg.addRecipient(Message.RecipientType.CC, new
	InternetAddress(cc[i]));
	}

	for(int i=0;i<bcc.length;i++){
	msg.addRecipient(Message.RecipientType.BCC, new
	InternetAddress(bcc[i]));
	}
	msg.saveChanges();

	Transport transport = session.getTransport("smtp");

	transport.connect(host, userName, passWord);
	//Send message
	transport.sendMessage(msg, msg.getAllRecipients());
	System.out.println("Email Sent Successfully");

	transport.close();

	return true;
	} 
	catch (Exception mex)
	{
		mex.printStackTrace();
		return false;
	}
	}
}




