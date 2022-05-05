package com.ajay.lms.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AddMockRatingsDTO {

	@NotNull
	@NotEmpty
	private String mockType;

	@NotEmpty
	@NotNull
	private String empid;
	
	@NotNull
	@NotEmpty
	private String mockTakenBy;
	
	@NotNull
	private Integer techId;
	
	@NotNull
	@Size(min = 0, max = 100)
	private double practical;
	
	@NotNull
	@Size(min = 0, max = 100)
	private double theoretical;
	
	@NotNull
	@Size(min = 0, max = 100)
	private double overall;
	
	@NotNull
	@NotEmpty
	private String detailedFeedBack;

}
