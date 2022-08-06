package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Customer;
import com.example.domain.user.service.CustomerService;
import com.example.form.CustomerDetailForm;

@Controller
@RequestMapping("/customer")
public class CustomerDetailController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ModelMapper modelMapper;
	/** Display user dietils screen */
	@GetMapping("/detail/{customerId:.+}")
	public String getCustomer(CustomerDetailForm form,Model model,
			@PathVariable("customerId") Integer customerId) {
		Customer customer= customerService.getCustomerOne(customerId);
		form = modelMapper.map(customer, CustomerDetailForm.class);
		
		model.addAttribute("customerDetailForm", form);
		return "customer/detail";
	}
	/** User update process */
	@PostMapping(value= "/detail", params = "update")
	public String updateCustomer(CustomerDetailForm form,Model model) {
		// encoded for password
//		String encoded = new BCryptPasswordEncoder().encode(form.getPassword());
		// update user
		customerService.updateCustomerOne(form.getCustomerId(), 
				form.getCustomerName(), 
				form.getPhone(),
				form.getIdentity(),
				form.getUserId());
		return "redirect:/customer/list";
	}
	
	/** User delete process */
	@PostMapping(value = "/detail", params = "delete")
	public String deleteCustomer(CustomerDetailForm form, Model model) {
	// Delete user
	customerService.deleteCustomerOne(form.getCustomerId());
	// Redirect to user list screen
	return "redirect:/customer/list";
	}
}
