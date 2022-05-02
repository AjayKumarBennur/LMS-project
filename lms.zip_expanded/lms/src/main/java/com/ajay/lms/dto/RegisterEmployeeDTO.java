package com.ajay.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.ajay.lms.pojo.Address;
import com.ajay.lms.pojo.BankDetails;
import com.ajay.lms.pojo.Contact;
import com.ajay.lms.pojo.EducationDetails;
import com.ajay.lms.pojo.Experience;
import com.ajay.lms.pojo.SecondaryInfo;
import com.ajay.lms.pojo.Technologies;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RegisterEmployeeDTO {
	private String empId;
	private String empName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate doj;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String status;

	private SecondaryInfo info;

	private List<EducationDetails> details;

	private List<Address> address;

	private BankDetails bankDetails;

	private List<Technologies> tech;

	private List<Experience> exp;

	private List<Contact> contact;

}
