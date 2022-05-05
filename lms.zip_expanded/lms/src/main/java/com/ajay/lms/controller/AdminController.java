package com.ajay.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.lms.dto.AddBatchDTO;
import com.ajay.lms.dto.AddMentorDTO;
import com.ajay.lms.dto.DropDownDTO;
import com.ajay.lms.dto.ResponseDTO;
import com.ajay.lms.pojo.BatchDetails;
import com.ajay.lms.pojo.Mentor;
import com.ajay.lms.pojo.Technologies;
import com.ajay.lms.service.AdminService;

@RestController
@RequestMapping("/lms/v1/admin/")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping("/batch")
	public ResponseEntity<ResponseDTO> addBatch(@RequestBody AddBatchDTO details) {
		BatchDetails addBatch = service.addBatch(details);
		return new ResponseEntity<>(new ResponseDTO(false, "Success", addBatch), HttpStatus.OK);
	}
	
	@PutMapping("/batch/{id}")
	public ResponseEntity<ResponseDTO> updateBatch(@RequestBody BatchDetails details,@PathVariable Integer id) {
		return new ResponseEntity<>(new ResponseDTO(false, "Success",service.update(details, id)),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/batch/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) {
		if(id==null) {
			throw new RuntimeException();
		}
		return new ResponseEntity<>(new ResponseDTO(false, "Deleted the batch successfully", null),HttpStatus.OK);
	}
	
	@PostMapping("/mentor")
	public ResponseEntity<ResponseDTO> addMentor(@RequestBody AddMentorDTO mentorDetails){
		Mentor addMentor = service.addMentor(mentorDetails);
		ResponseDTO body = new ResponseDTO(false, "Add mentor Successfully", addMentor);
		return new ResponseEntity<ResponseDTO>(body, HttpStatus.OK);
	}
	
	@GetMapping("/batch")
	public ResponseEntity<ResponseDTO> getAllBatchDetails(){
		List<BatchDetails> allBatchDetails = service.getAllBatchDetails();
		return new ResponseEntity<>(new ResponseDTO(false, "All batch details fetched Successfully", allBatchDetails),HttpStatus.OK);
	}
	
	@GetMapping("/mentor")
	public ResponseEntity<ResponseDTO> getAllMentorDetails(){
		List<Mentor> allMentorDetails = service.getAllMentorDetails();
		return new ResponseEntity<>(new ResponseDTO(false, "All metnor Details fetched Successfully", allMentorDetails),HttpStatus.OK);
	}
	
	@GetMapping("/technologies")
	public ResponseEntity<ResponseDTO> getAllTechnologies(){
		List<Technologies> allTechnologies = service.getAllTechnologies();
		return new ResponseEntity<>(new ResponseDTO(false, "All technologies fetched Succesfully", allTechnologies), HttpStatus.OK);
	}
	
	@GetMapping("/mentorname")
	public ResponseEntity<ResponseDTO> getMentorDropDown(){
		List<DropDownDTO> mentorName = service.getMentorName();
		return new ResponseEntity<>(new ResponseDTO(false, "All mentor name successfully fetched", mentorName),HttpStatus.OK);
	}
	
}
