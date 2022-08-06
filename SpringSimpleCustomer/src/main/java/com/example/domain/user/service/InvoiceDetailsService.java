package com.example.domain.user.service;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.InvoiceDetails;
import com.example.domain.user.model.Merchandise;

public interface InvoiceDetailsService {
	/** User signup */
	public void signupInvoiceDetails(InvoiceDetails invoiceDetails);
	/** Get user */
	public List<InvoiceDetails> getInvoiceDetails(InvoiceDetails invoiceDetails);
	/** Get user(1record) */
	public InvoiceDetails getInvoiceDetailsOne(Integer invoiceDetailsId);
	
	/** Get user */
	public List<Merchandise> getMerchandises();
	/** Get user */
	public List<InvoiceDetails> getInvoiceDetails();
	/** Get user(1record) */
	public List<InvoiceDetails> findByMerchandise(int id);
	
	/** Update user */
	public void updateInvoiceDetailsOne(Integer invoiceDetailsId,Integer customerId,Integer merchandiseId, 
			Date inDate,Integer amountInvoice,Double totalMoney);
	/** Delete user */
	public void deleteInvoiceDetailsOne(Integer invoiceDetailsId);
}
