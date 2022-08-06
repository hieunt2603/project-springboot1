package com.example.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.InvoiceDetails;
import com.example.domain.user.model.Merchandise;

@Mapper
public interface InvoiceDetailsMapper {
	/** User signup */
	public int insertOne(InvoiceDetails invoiceDetails);
	
	/** Get User*/
	public List<InvoiceDetails> findMany(InvoiceDetails invoiceDetails);
	
	/** Get User*/
	public List<Merchandise> getMerchandises();
	/** Get User*/
	public List<InvoiceDetails> getInvoiceDetails();
	/** Get User*/
	public List<InvoiceDetails> findByMerchandise(@Param("merchandiseId") int id);
	
	/** Get user (1 record) */
	public InvoiceDetails findOne(Integer invoiceDetailsId);
	/** Update user */
	public void updateOne(@Param ("invoiceDetailsId") Integer invoiceDetailsId,
					@Param ("customerId") Integer customerId,
					@Param ("merchandiseId") Integer merchandiseId,
					@Param ("inDate") Date inDate,
					@Param ("amountInvoice") Integer amountInvoice,
					@Param ("totalMoney") Double totalMoney);
	/** Delete user */
	public int deleteOne(@Param ("invoiceDetailsId") Integer invoiceDetailsId);
}
