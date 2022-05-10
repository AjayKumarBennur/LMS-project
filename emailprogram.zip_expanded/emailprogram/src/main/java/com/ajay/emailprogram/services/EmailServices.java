package com.ajay.emailprogram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
	
	@Autowired
	JavaMailSender emaiSender;
	
	public void sendMessage(String to, String subject,String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ajaybennur8@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		this.emaiSender.send(message);
		
	}
	
	
}
