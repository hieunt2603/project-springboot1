package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class InvoiceDetails {
	private Integer invoiceDetailsId;
	private Integer customerId;
	private Integer merchandiseId;
	private Date inDate;
	private Integer amountInvoice;
	private Double totalMoney;
}
