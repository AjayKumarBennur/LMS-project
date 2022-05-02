package com.ajay.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.lms.dto.ResponseBody;
import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.MockRatings;
import com.ajay.lms.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	
	/*
	 * EMployee Registration
	 */
	@PostMapping("/")
	public ResponseEntity<ResponseBody> register(@RequestBody Employee employee) {
		 Employee addEmployee = service.addEmployee(employee);
		 return new ResponseEntity<ResponseBody>(new ResponseBody(false, "Success", addEmployee), HttpStatus.OK);
	}
	
	
	/*
	 * Fetching mock details
	 */
	@GetMapping("/mockratings/{name}")
	public ResponseEntity<ResponseBody> getMockDetails(@PathVariable String name){
		List<MockRatings> mockDetails = service.getMockDetails(name);
		return new ResponseEntity<>(new ResponseBody(false, "success", mockDetails), HttpStatus.OK);
	}
	
	/*
	 * Fetching employee Details
	 */
	@GetMapping("/employee/{name}")
	public ResponseEntity<ResponseBody> getDetails(@PathVariable String name){
		Employee details = service.getDetails(name);
		return new ResponseEntity<>(new ResponseBody(false, "success", details), HttpStatus.OK);
	}
	
	/*
	 * Updating employee Details
	 */
	@PutMapping("/")
	public ResponseEntity<ResponseBody> updateEmployeeDetails(@RequestBody Employee employee,@PathVariable Integer id){
		if(id==null) {
			throw new RuntimeException();
		}
		Employee updateEmployeeDeatils = service.updateEmployeeDeatils(employee,id);
		return new ResponseEntity<ResponseBody>(new ResponseBody(false, "success", updateEmployeeDeatils), HttpStatus.OK);
	}
	
}
