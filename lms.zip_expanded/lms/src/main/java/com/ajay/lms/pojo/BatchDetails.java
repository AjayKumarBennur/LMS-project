package com.ajay.lms.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class BatchDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "batch_number")
	private int number;

	private String batchName;
	
	@ManyToOne
	@JsonManagedReference
	private Mentor mentor;
	
	@OneToMany
	private List<Technologies> technologies;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate startDate;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate endDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Mock> mock;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employees;
	
	private String status;
	
}
