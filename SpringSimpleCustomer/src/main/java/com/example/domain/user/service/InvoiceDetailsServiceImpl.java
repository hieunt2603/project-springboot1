package com.example.domain.user.service;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.InvoiceDetails;
import com.example.domain.user.model.Merchandise;
import com.example.repository.InvoiceDetailsMapper;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService{
	@Autowired
	private InvoiceDetailsMapper mapper;
	@Override
	public void signupInvoiceDetails(InvoiceDetails invoiceDetails) {
		mapper.insertOne(invoiceDetails);
		
	}

	@Override
	public List<InvoiceDetails> getInvoiceDetails(InvoiceDetails invoiceDetails) {
		
		return mapper.findMany(invoiceDetails);
	}

	@Override
	public InvoiceDetails getInvoiceDetailsOne(Integer invoiceDetailsId) {
		return mapper.findOne(invoiceDetailsId);
	}

	@Override
	public void updateInvoiceDetailsOne(Integer invoiceDetailsId, Integer customerId, Integer merchandiseId,
			Date inDate, Integer amountInvoice, Double totalMoney) {
		mapper.updateOne(invoiceDetailsId, customerId, merchandiseId, inDate, amountInvoice, totalMoney);
		
	}

	@Override
	public void deleteInvoiceDetailsOne(Integer invoiceDetailsId) {
		mapper.deleteOne(invoiceDetailsId);
		
	}

	@Override
	public List<InvoiceDetails> getInvoiceDetails() {
		return mapper.getInvoiceDetails();
	}

	@Override
	public List<InvoiceDetails> findByMerchandise(int id) {
		return mapper.findByMerchandise(id);
	}

	@Override
	public List<Merchandise> getMerchandises() {
		return mapper.getMerchandises();
	}

}
