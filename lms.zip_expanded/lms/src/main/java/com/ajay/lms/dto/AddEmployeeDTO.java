package com.ajay.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.ajay.lms.pojo.Address;
import com.ajay.lms.pojo.BankDetails;
import com.ajay.lms.pojo.Contact;
import com.ajay.lms.pojo.EducationDetails;
import com.ajay.lms.pojo.Experience;
import com.ajay.lms.pojo.SecondaryInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AddEmployeeDTO {

	private String empId;
	private String empName;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate doj;
	@JsonFormat(pattern ="yyyy/MM/dd")
	private LocalDate dob;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String status;
	
	
	private SecondaryInfo info;
	
	private List<EducationDetails> educationDetails;
	
	private List<Address> address;
	
	private BankDetails bankDetails;
	
	private List<Integer> tech;
	
	private List<Experience> exp;
	
	private List<Contact> contact;
}
