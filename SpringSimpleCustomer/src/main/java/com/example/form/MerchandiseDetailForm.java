package com.example.form;

import lombok.Data;

@Data
public class MerchandiseDetailForm {
	private Integer merchandiseId;
	private String merchandiseName;
	private Integer amount;
	private Double money;
}
