package com.ajay.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.lms.pojo.Technologies;

public interface TechnologiesRepo extends JpaRepository<Technologies, Integer>{
}
