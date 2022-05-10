package com.ajay.lms.service;

import java.util.List;

import com.ajay.lms.dto.AddBatchDTO;
import com.ajay.lms.dto.AddMentorDTO;
import com.ajay.lms.dto.DropDownDTO;
import com.ajay.lms.dto.EmpRequestResDTO;
import com.ajay.lms.dto.RejectDTO;
import com.ajay.lms.dto.RequestApproveDTO;
import com.ajay.lms.pojo.BatchDetails;
import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.EmployeeRequest;
import com.ajay.lms.pojo.Mentor;
import com.ajay.lms.pojo.Technologies;

public interface AdminService {
	
	public BatchDetails addBatch(AddBatchDTO details);

	public BatchDetails update(BatchDetails details,int id);

	public void delete(Integer id);

	public Mentor addMentor(AddMentorDTO mentor);

	public List<BatchDetails> getAllBatchDetails();

	public List<Mentor> getAllMentorDetails();

	public List<Technologies> getAllTechnologies();

	public List<DropDownDTO> getMentorName();

	public List<EmpRequestResDTO> getEmpRequest();

	public List<Employee> approveRequest(RequestApproveDTO approve);

	public Mentor deleteMentor(Integer id);

	public List<EmployeeRequest> rejectRequest(RejectDTO reject);
	
}
