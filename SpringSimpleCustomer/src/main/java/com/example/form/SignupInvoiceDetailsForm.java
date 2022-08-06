package com.example.form;

import java.util.Date;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupInvoiceDetailsForm {
	@NotNull(groups = ValidGroup1.class)
	private Integer customerId;
	
	@NotNull(groups = ValidGroup1.class)
	private Integer merchandiseId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(groups = ValidGroup1.class)
	private Date inDate;
	
	@NotNull(groups = ValidGroup1.class)
	private Integer amountInvoice;
	
	@NotNull(groups = ValidGroup1.class)
	private Double totalMoney;
}
