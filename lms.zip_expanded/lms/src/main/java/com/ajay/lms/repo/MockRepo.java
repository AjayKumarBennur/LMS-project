package com.ajay.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.lms.pojo.Mock;

@Repository
public interface MockRepo extends JpaRepository<Mock, Integer>{

}
