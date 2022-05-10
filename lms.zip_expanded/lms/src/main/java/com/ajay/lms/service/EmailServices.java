package com.ajay.lms.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {

	@Autowired
	JavaMailSender mailSender;
	

	public void sendPassword(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ajaybennur8@gmail.com");
		message.setTo(to);
		message.setSubject("Auto Generated Password");
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		message.setText("The password ==> "+uuid);
		this.mailSender.send(message);
		
	}
}
