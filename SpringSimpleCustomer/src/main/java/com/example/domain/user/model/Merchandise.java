package com.example.domain.user.model;

import lombok.Data;

@Data
public class Merchandise {
	private Integer merchandiseId;
	private String merchandiseName;
	private Integer amount;
	private Double money;
}
