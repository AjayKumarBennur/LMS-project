package com.ajay.lms.controlleradvice;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ajay.lms.dto.ResponseDTO;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseDTO> duplicateEntryOfEmpId(){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "Duplicate entry of empId", null), HttpStatus.BAD_REQUEST);
	}
	
}
