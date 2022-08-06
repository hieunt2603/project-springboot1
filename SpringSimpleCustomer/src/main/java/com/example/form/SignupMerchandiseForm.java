package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignupMerchandiseForm {
	@NotBlank(groups = ValidGroup1.class)
	private String merchandiseName;
	
	@NotNull(groups = ValidGroup1.class)
	private Integer amount;
	
	@NotNull(groups = ValidGroup1.class)
	private Double money;
	
}
