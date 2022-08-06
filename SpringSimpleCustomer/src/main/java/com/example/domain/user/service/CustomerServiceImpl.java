package com.example.domain.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.Customer;
import com.example.domain.user.model.MUser;
import com.example.repository.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper mapper;
	@Override
	public void signupCustomer(Customer customer) {
		mapper.insertOne(customer);
		
	}

	@Override
	public List<Customer> getCustomers(Customer customer) {
		return mapper.findMany(customer);
	}

	@Override
	public Customer getCustomerOne(Integer customerId) {
		return mapper.findOne(customerId);
	}
	
	@Override
	public void updateCustomerOne(Integer customerId, String customerName, String phone, String identity,
			String userId) {
		mapper.updateOne(customerId, customerName, phone, identity, userId);
		
	}
	
	@Override
	public void deleteCustomerOne(Integer customerId) {
		mapper.deleteOne(customerId);
	
	}

	@Override
	public List<MUser> getUsers() {
		return mapper.getUsers();
	}

	@Override
	public List<Customer> getCustomers() {
		return mapper.getCustomers();
	}

	@Override
	public List<Customer> findByUser(String id) {
		return mapper.findByUser(id);
	}
}
