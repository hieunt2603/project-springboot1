package com.example.domain.user.service;

import java.util.List;
import com.example.domain.user.model.Customer;
import com.example.domain.user.model.MUser;

public interface CustomerService {
	/** User signup */
	public void signupCustomer(Customer customer);
	/** Get user */
	public List<Customer> getCustomers(Customer customer);
	
	/** Get user */
	public List<Customer> getCustomers();
	/** Get user */
	public List<MUser> getUsers();
	/** Get user(1record) */
	public List<Customer> findByUser(String id);
	
	/** Get user(1record) */
	public Customer getCustomerOne(Integer customerId);
	/** Update user */
	public void updateCustomerOne(Integer customerId,String customerName,String phone, 
			String identity,String userId);
	/** Delete user */
	public void deleteCustomerOne(Integer customerId);

}
