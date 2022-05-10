package com.ajay.emailprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.emailprogram.services.EmailServices;

@RestController
public class EmailController {

	@Autowired
	EmailServices services;
	
	@PostMapping("/sendmessage")
	public String sendMailMessage(String to, String subject,String text) {
		services.sendMessage(to,subject,text);
		return "message sent";
	}
	
}
