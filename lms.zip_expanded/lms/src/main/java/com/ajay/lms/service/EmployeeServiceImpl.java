package com.ajay.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.MockRatings;
import com.ajay.lms.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee save = empRepo.save(employee);
		if (save == null) {
			throw new RuntimeException();
		}
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
		empDetails.setAddress(employee.getAddress());
		empDetails.setBankDetails(employee.getBankDetails());
		empDetails.setBloodGroup(employee.getBloodGroup());
		empDetails.setContact(employee.getContact());
		empDetails.setDesignation(employee.getDesignation());
		empDetails.setEducationDetails(employee.getEducationDetails());
		empDetails.setDob(employee.getDob());
		empDetails.setDoj(employee.getDoj());
		empDetails.setEmail(employee.getEmail());
		empDetails.setEmpId(employee.getEmpId());
		empDetails.setEmpName(employee.getEmpName());
		empDetails.setExp(employee.getExp());
		empDetails.setGender(employee.getGender());
		empDetails.setInfo(employee.getInfo());
		empDetails.setNationality(employee.getNationality());
		empDetails.setTech(employee.getTech());
		return empDetails;
	}

}
