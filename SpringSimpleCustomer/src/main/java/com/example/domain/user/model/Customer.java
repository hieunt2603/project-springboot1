package com.example.domain.user.model;

import lombok.Data;

@Data
public class Customer {
	private Integer customerId;
	private String customerName;
	private String phone;
	private String identity;
	private String userId;
}
