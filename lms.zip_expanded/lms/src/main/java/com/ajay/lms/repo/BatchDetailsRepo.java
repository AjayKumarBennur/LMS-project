package com.ajay.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajay.lms.pojo.BatchDetails;
import com.ajay.lms.pojo.Mentor;

public interface BatchDetailsRepo extends JpaRepository<BatchDetails, Integer>{
	
	public BatchDetails findIdByBatchName(String batchname);
	
	public List<BatchDetails> findByMentor(Mentor id);
}
