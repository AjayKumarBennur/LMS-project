package com.ajay.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.lms.dto.AddMockDTO;
import com.ajay.lms.dto.AddMockRatingsDTO;
import com.ajay.lms.dto.DropDownDTO;
import com.ajay.lms.dto.EmployeeStatusDTO;
import com.ajay.lms.dto.MentorBatchResDto;
import com.ajay.lms.pojo.BatchDetails;
import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.Mentor;
import com.ajay.lms.pojo.Mock;
import com.ajay.lms.pojo.MockRatings;
import com.ajay.lms.pojo.Technologies;
import com.ajay.lms.repo.BatchDetailsRepo;
import com.ajay.lms.repo.EmployeeRepo;
import com.ajay.lms.repo.MentorRepo;
import com.ajay.lms.repo.MockRatingsRepo;
import com.ajay.lms.repo.MockRepo;
import com.ajay.lms.repo.TechnologiesRepo;

import lombok.extern.log4j.Log4j2;

@Service
public class MetnorServiceImpl implements MentorService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private MentorRepo mentorRepo;

	@Autowired
	private BatchDetailsRepo batchDetailsRepo;

	@Autowired
	private MockRepo mockRepo;

	@Autowired
	private MockRatingsRepo mockRatingsRepo;

	@Autowired
	private TechnologiesRepo technologiesRepo;

	@Override
	public List<Employee> getAllEmployee(String batchName) {
		System.out.println("id---------------->" + batchDetailsRepo.findIdByBatchName(batchName));
		BatchDetails batch = batchDetailsRepo.findIdByBatchName(batchName);
		if (batch == null) {
			throw new RuntimeException();
		}
		return batch.getEmployees();
	}

	@Override
	public List<MockRatings> getEmployeeDetails(String empId) {

		Employee empDetails = empRepo.findByEmpId(empId);
		if (empDetails == null) {
			throw new RuntimeException("Emp id doesnot exist");
		}
		if (empDetails.getRatings().size() < 1) {
			throw new RuntimeException("No Ratings for empId");
		}
		return empDetails.getRatings();
	}

	@Override
	public Mock createMock(AddMockDTO mockdetails) {
		Mock mock = new Mock();
		mock.setMockNo(mockdetails.getMockNo());
		Technologies technologies = technologiesRepo.findById(mockdetails.getTechId()).get();
		mock.setTech(technologies);
		List<Mentor> mentorDetails = mentorRepo.findByEmpIdIn(mockdetails.getMentorId());
		mock.setPanel(mentorDetails);
		mock.setDate(mockdetails.getDateTime());
		return mock;
	}

	@Override
	public MockRatings giveMockRatings(AddMockRatingsDTO ratings) {
		MockRatings mockRatings = new MockRatings();
		BeanUtils.copyProperties(ratings, mockRatings);
		return null;
	}

	@Override
	public List<DropDownDTO> getBatchNameByMentor(String mentorId) {
		Mentor mentor = mentorRepo.findByEmpId(mentorId);
		List<BatchDetails> batchDetails = mentor.getBatchDetails();
		List<DropDownDTO> dropDown = new ArrayList<>();
		batchDetails.stream().forEach(b -> {
			DropDownDTO response = new DropDownDTO();
			response.setId(b.getId());
			response.setName(b.getBatchName());
			dropDown.add(response);
		});
		if (dropDown.size() < 1) {
			throw new RuntimeException();
		}
		return dropDown;
	}

	@Override
	public List<EmployeeStatusDTO> getstatus(Integer batchId) {
		BatchDetails batchDetails = batchDetailsRepo.findById(batchId).get();
		List<Employee> employees = batchDetails.getEmployees();
		if (employees.size() == 0) {
			throw new RuntimeException("No employees in the batch");
		}
		List<EmployeeStatusDTO> list = new ArrayList<>();
		employees.stream().forEach(e -> {
			EmployeeStatusDTO employeeStatusDTO = new EmployeeStatusDTO();
			employeeStatusDTO.setEmpId(e.getId());
			employeeStatusDTO.setEmpName(e.getEmpName());
			employeeStatusDTO.setMocksTaken(e.getRatings().size());
			employeeStatusDTO.setStatus(e.getStatus());
			list.add(employeeStatusDTO);
		});
		return list;
	}

	@Override
	public List<MentorBatchResDto> getAllBatch(Integer mentorId) {
		Mentor mentor = mentorRepo.findById(mentorId).get();
		List<BatchDetails> mentorBatchDetails = batchDetailsRepo.findByMentor(mentor);
		List<MentorBatchResDto> arrayList = new ArrayList<>();
		mentorBatchDetails.stream().forEach(m->{
			MentorBatchResDto mentorBatchResDto = new MentorBatchResDto();
			mentorBatchResDto.setBatchId(m.getId());
			mentorBatchResDto.setBatchName(m.getBatchName());
			mentorBatchResDto.setBatchNo(m.getNumber());
			mentorBatchResDto.setBatchStrength(m.getEmployees().stream().count());
			mentorBatchResDto.setStartDate(m.getStartDate());
			mentorBatchResDto.setEndDate(m.getEndDate());
			mentorBatchResDto.setStatus(m.getStatus());
			List<String> list = new ArrayList<String>();
			m.getTechnologies().stream().forEach(t->{list.add(t.getTech());});
			mentorBatchResDto.setTechnologies(list);
			arrayList.add(mentorBatchResDto);
			});
		return arrayList;
	}

	
}
