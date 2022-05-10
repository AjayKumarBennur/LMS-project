package com.ajay.lms.dto;

import java.util.List;

import com.ajay.lms.pojo.Employee;

import lombok.Data;

@Data
public class RequestApproveDTO {
	
	private String batchName;
	private int batchId;
	private List<Integer> employeesId;

}
