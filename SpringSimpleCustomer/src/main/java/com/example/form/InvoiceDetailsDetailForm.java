package com.example.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InvoiceDetailsDetailForm {
	private Integer invoiceDetailsId;
	private Integer customerId;
	private Integer merchandiseId;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date inDate;
	private Integer amountInvoice;
	private Double totalMoney;
}
