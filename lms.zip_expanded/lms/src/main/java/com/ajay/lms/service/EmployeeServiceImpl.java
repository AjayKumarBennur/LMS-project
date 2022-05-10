package com.ajay.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.lms.dto.AddEmployeeDTO;
import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.EmployeeRequest;
import com.ajay.lms.pojo.MockRatings;
import com.ajay.lms.pojo.Technologies;
import com.ajay.lms.repo.EmployeeRepo;
import com.ajay.lms.repo.EmployeeRequestRepo;
import com.ajay.lms.repo.TechnologiesRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private TechnologiesRepo technologiesRepo;
	
	@Autowired
	private EmployeeRequestRepo requestRepo;
	
	@Override
	public Employee addEmployee(AddEmployeeDTO employeedetails) {
		List<Integer> tech = employeedetails.getTech();
		List<Technologies> findAllById = technologiesRepo.findAllById(tech);
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeedetails, employee);
		employee.setTech(findAllById);
		Employee save = empRepo.save(employee);
		if (save == null) {
			throw new RuntimeException();
		}
		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setEmpId(save.getId());
		requestRepo.save(employeeRequest);
		return save;
	}

	@Override
	public List<MockRatings> getMockDetails(String name) {
		Employee findByEmpName = empRepo.findByEmpName(name);
		List<MockRatings> ratings = findByEmpName.getRatings();
		System.out.println("mock rating ==========> " + ratings);
		if (ratings == null) {
			throw new RuntimeException();
		}
		return ratings;
	}

	@Override
	public Employee getDetails(String name) {
		Employee empName = empRepo.findByEmpName(name);
		if (empName.getStatus().equals("Active")) {
			return empName;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public Employee updateEmployeeDeatils(Employee employee, Integer id) {
		Employee empDetails = empRepo.findById(id).get();
		BeanUtils.copyProperties(employee, empDetails);
		return empDetails;
	}

}
