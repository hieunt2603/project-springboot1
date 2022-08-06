package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.user.model.Customer;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.CustomerService;

@Controller
@RequestMapping("customer")
public class SearchCustomerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping("/search")
	public String getSearchCustomer(@ModelAttribute("user") MUser user, Model model) {
		List<MUser> userList = service.getUsers();
		List<Customer> customerList = service.getCustomers();
		model.addAttribute("customerList", customerList);
		model.addAttribute("userList", userList);
		return "customer/search";
	}

	@PostMapping("/search")
	public String postSearchCustomer(@ModelAttribute("user") MUser user, Model model) {
		List<MUser> userList = service.getUsers();
		List<Customer> customerList = service.findByUser(user.getUserId());
		model.addAttribute("userList", userList);
		model.addAttribute("customerList", customerList);
		return "customer/search";
	}
}
