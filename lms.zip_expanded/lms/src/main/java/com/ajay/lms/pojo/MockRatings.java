package com.ajay.lms.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class MockRatings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mockType;
	private String mockTakenBy;
	@ManyToOne(cascade = CascadeType.ALL)
	private Technologies tech;
	private int practical;
	private int therotical;
	private int overAll;
	private String detailedFeedBack;
	@ManyToOne
	@JsonBackReference
	private Employee employee;

}
