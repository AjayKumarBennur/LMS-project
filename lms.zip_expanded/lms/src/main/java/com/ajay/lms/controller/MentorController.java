package com.ajay.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.lms.dto.AddMockDTO;
import com.ajay.lms.dto.AddMockRatingsDTO;
import com.ajay.lms.dto.DropDownDTO;
import com.ajay.lms.dto.EmployeeStatusDTO;
import com.ajay.lms.dto.MentorBatchResDto;
import com.ajay.lms.dto.ResponseDTO;
import com.ajay.lms.pojo.Mock;
import com.ajay.lms.pojo.MockRatings;
import com.ajay.lms.service.MentorService;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

	@Autowired
	private MentorService service;

	
	@GetMapping("/batchname/{mentorId}")
	public ResponseEntity<ResponseDTO> getBatchName(@PathVariable String mentorId){
		List<DropDownDTO> batchname = service.getBatchNameByMentor(mentorId);
		return new ResponseEntity<>(new ResponseDTO(false, "Batch Name of mentor fetched successfully", batchname), HttpStatus.OK);
	}
	
	@GetMapping("/batchdetails/{batchId}")
	public ResponseEntity<ResponseDTO> getBatchDetailsOfMentor(@PathVariable Integer batchId){
		List<EmployeeStatusDTO> getstatus = service.getstatus(batchId);
		return new ResponseEntity<>(new ResponseDTO(false, "Employee Details of batch fetched successfully for dashboard drop down", getstatus),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/employeeDetails/{empId}")
	public ResponseEntity<ResponseDTO> getDetailsOfEmployee(@PathVariable String empId){
		List<MockRatings> details = service.getEmployeeDetails(empId);
		return new ResponseEntity<>(new ResponseDTO(false, "Mock Rating of a employee", details),HttpStatus.OK);
		
	}
	
	@PostMapping("/mock")
	public ResponseEntity<ResponseDTO> addMock(@RequestBody AddMockDTO mock){
		Mock createMock = service.createMock(mock);
        return	new ResponseEntity<>(new ResponseDTO(false, "Mock created", createMock), HttpStatus.OK);
	}

	@PostMapping("/mockRatings")
	public ResponseEntity<ResponseDTO> giveMockRatings(@RequestBody AddMockRatingsDTO ratings){
		MockRatings giveMockRatings = service.giveMockRatings(ratings);
		return new ResponseEntity<>(new ResponseDTO(false, "Mock Ratings submitted", giveMockRatings),HttpStatus.OK);
	}
	
	@GetMapping("/mentorbatch/{mentorId}")
	public ResponseEntity<ResponseDTO> getAllBatchs(@PathVariable Integer mentorId){
		List<MentorBatchResDto> allBatch = service.getAllBatch(mentorId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Mentor Batch Details feteched successfully", allBatch), HttpStatus.OK);
	}
}
