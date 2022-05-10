package com.ajay.lms.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmpRequestResDTO {
	private Integer empId;
	private String empName;
	private	int yop;
	private double percentage;
	private String experience;
	private long contactNo;
}
