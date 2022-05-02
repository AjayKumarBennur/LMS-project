package com.ajay.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.lms.pojo.BatchDetails;

public interface BatchDetailsRepo extends JpaRepository<BatchDetails, Integer>{
	
	public BatchDetails findIdByBatchName(String batchname);
	
}
