package com.ajay.emailprogram.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Mail {
	private String mailFrom;
	private String mailTo;
	private String mailCc;
	private String mailSubject;
	private String mailContent;
	private String contentType;
	private List<Object> attachements;
}
