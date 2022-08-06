package com.example.form;

import lombok.Data;

@Data
public class CustomerDetailForm {
	private Integer customerId;
	private String customerName;
	private String phone;
	private String identity;
	private String userId;
}
