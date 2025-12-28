package com.raj.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class ShoppingMgntService implements IShoppingService  {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Override
	public String shopping(String[] items, double[] prices, String[] toMails)throws Exception {
		
		//calculate bill amount
		double billAmt = 0.0;
		
		for(double price : prices)
			billAmt+=price;
		
		//generate message
		String txMsg = Arrays.toString(items)+" !! are purchased having prices "+Arrays.toString(prices)+" with bill Amount:: "+billAmt;
		
		//send mail
		
		String statusMsg = sendMail(txMsg,toMails);
		
		return txMsg+"...."+statusMsg;
	}
	
	private String sendMail(String bodyMsg, String toMails[]) throws Exception{
		
		//create mail message
		MimeMessage message = sender.createMimeMessage();
		
		//create Helper message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		//set message headers
		helper.setFrom(fromEmail);
//		helper.setTo(toMails);
		helper.setBcc(toMails);
		helper.setSentDate(new Date());
		helper.setSubject("Open it to know it");
		
		//set message body-part1(text)
		helper.setText(bodyMsg);
		
		//set attachment body-part2(image)
		helper.addAttachment("rajesh.jpg", new ClassPathResource("rajesh.jpg"));
		sender.send(message);
		
		return "mail has been delivered to :: "+Arrays.toString(toMails);
	}

}
