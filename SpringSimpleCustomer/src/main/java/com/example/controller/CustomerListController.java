package com.example.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.domain.user.model.Customer;
import com.example.domain.user.service.CustomerService;
import com.example.form.CustomerListForm;
import com.example.form.GroupOrder;
import com.example.form.SignupCustomerForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerListController {
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/list")
	public String getCustomerList(@ModelAttribute CustomerListForm form,Model model) {
		
		Customer customer = modelMapper.map(form, Customer.class);
		
		List<Customer> customerList = customerService.getCustomers(customer);
		model.addAttribute("customerList",customerList);
		return "customer/list";
	}
	@PostMapping("/list")
	public String postCustomerList(@ModelAttribute CustomerListForm form,Model model) {
		
		Customer customer = modelMapper.map(form, Customer.class);
		
		List<Customer> customerList = customerService.getCustomers(customer);
		model.addAttribute("customerList",customerList);
		return "customer/list";
	}
	@GetMapping("/add")
	public String getCustomerList(Locale locale,Model model,
			@ModelAttribute SignupCustomerForm form) {
		Map<String,Integer> customerMap = userApplicationService.getMap(locale);
		model.addAttribute("customerMap",customerMap);
		
//		MUser user = modelMapper.map(form, MUser.class);
//		List<MUser> userList = userService.getUsers(user);
//		
//		model.addAttribute("userList",userList);
		return "customer/add";
	}
	@PostMapping("/add")
	public String postSignup(Model model, Locale locale,
			@ModelAttribute @Validated(GroupOrder.class) SignupCustomerForm form,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return getCustomerList(locale, model, form);
		}
		
		Customer customer = modelMapper.map(form, Customer.class);
		
//		MUser user = modelMapper.map(form, MUser.class);
//		List<MUser> userList = userService.getUsers(user);
//		
//		model.addAttribute("userList",userList);
		
		customerService.signupCustomer(customer);
		
		log.info(form.toString());
		// Redirect to login screen
		return "redirect:/customer/list";
	}
}
