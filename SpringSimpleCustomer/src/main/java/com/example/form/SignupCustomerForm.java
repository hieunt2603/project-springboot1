package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupCustomerForm {
	@NotBlank(groups = ValidGroup1.class)
	private String customerName;
	
	@NotBlank(groups = ValidGroup1.class)
	private String phone;
	
	@NotBlank(groups = ValidGroup1.class)
	private String identity;
	
	@NotBlank(groups = ValidGroup1.class)
	private String userId;
}
