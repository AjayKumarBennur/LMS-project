package com.ajay.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.lms.pojo.MockRatings;

public interface MockRatingsRepo extends JpaRepository<MockRatings, Integer>{

}
