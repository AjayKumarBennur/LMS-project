package com.ajay.lms.dto;

import java.util.List;

import lombok.Data;

@Data
public class AddMentorDTO {
	private String name;
	private String empId;
	private String emailId;
	private List<Integer> techId;
}
