package com.ajay.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.lms.pojo.EmployeeRequest;

@Repository
public interface EmployeeRequestRepo extends JpaRepository<EmployeeRequest, Integer>{

	public void deleteByEmpIdIn(List<Integer> empId);
}
