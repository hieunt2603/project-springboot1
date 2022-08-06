package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.domain.user.model.Customer;
import com.example.domain.user.model.MUser;

@Mapper
public interface CustomerMapper {
	/** User signup */
	public int insertOne(Customer customer);
	
	/** Get User*/
	public List<Customer> findMany(Customer customer);
	
	/** Get User*/
	public List<MUser> getUsers();
	/** Get User*/
	public List<Customer> getCustomers();
	/** Get User*/
	public List<Customer> findByUser(@Param("userId") String id);
	
	/** Get user (1 record) */
	public Customer findOne(Integer customerId);
	/** Update user */
	public void updateOne(@Param ("customerId") Integer customerId,
					@Param ("customerName") String customerName,
					@Param ("phone") String phone,
					@Param ("identity") String identity,
					@Param ("userId") String userId);
	/** Delete user */
	public int deleteOne(@Param ("customerId") Integer customerId);
}
