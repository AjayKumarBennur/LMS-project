package com.ajay.lms.service;

import java.util.List;

import com.ajay.lms.dto.AddMockDTO;
import com.ajay.lms.dto.AddMockRatingsDTO;
import com.ajay.lms.dto.DropDownDTO;
import com.ajay.lms.dto.EmployeeStatusDTO;
import com.ajay.lms.dto.MentorBatchResDto;
import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.Mock;
import com.ajay.lms.pojo.MockRatings;

public interface MentorService {
	
	public List<Employee> getAllEmployee(String batchName);

	public List<MockRatings> getEmployeeDetails(String name);

	public Mock createMock(AddMockDTO mock);

	public MockRatings giveMockRatings(AddMockRatingsDTO ratings);

	public List<DropDownDTO> getBatchNameByMentor(String mentorName);

	public List<EmployeeStatusDTO> getstatus(Integer batchId);

	public List<MentorBatchResDto> getAllBatch(Integer mentorId);
}
