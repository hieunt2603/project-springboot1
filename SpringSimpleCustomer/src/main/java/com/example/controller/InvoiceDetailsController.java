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
import com.example.domain.user.model.InvoiceDetails;
import com.example.domain.user.service.InvoiceDetailsService;
import com.example.form.GroupOrder;
import com.example.form.InvoiceDetailsListForm;
import com.example.form.SignupInvoiceDetailsForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/invoiceDetails")
@Slf4j
public class InvoiceDetailsController {
	@Autowired
	private UserApplicationService userApplicationService;
	@Autowired
	private InvoiceDetailsService invoiceDetailsService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/list")
	public String getInvoiceDetailsList(@ModelAttribute InvoiceDetailsListForm form,Model model) {
		
		InvoiceDetails invoiceDetails = modelMapper.map(form, InvoiceDetails.class);
		
		List<InvoiceDetails> invoiceDetailsList = invoiceDetailsService.getInvoiceDetails(invoiceDetails);
		model.addAttribute("invoiceDetailsList",invoiceDetailsList);
		return "invoiceDetails/list";
	}
	@PostMapping("/list")
	public String postInvoiceDetailsList(@ModelAttribute InvoiceDetailsListForm form,Model model) {
		
		InvoiceDetails invoiceDetails = modelMapper.map(form, InvoiceDetails.class);
		
		List<InvoiceDetails> invoiceDetailsList = invoiceDetailsService.getInvoiceDetails(invoiceDetails);
		model.addAttribute("invoiceDetailsList",invoiceDetailsList);
		return "invoiceDetails/list";
	}
	
	@GetMapping("/add")
	public String getInvoiceDetailsList(Locale locale,Model model,
			@ModelAttribute SignupInvoiceDetailsForm form) {
		Map<String,Integer> invoiceDetailsMap = userApplicationService.getMap(locale);
		model.addAttribute("invoiceDetailsMap",invoiceDetailsMap);
		
		return "invoiceDetails/add";
	}
	
	@PostMapping("/add")
	public String postSignup(Model model, Locale locale,
			@ModelAttribute @Validated(GroupOrder.class) SignupInvoiceDetailsForm form,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return getInvoiceDetailsList(locale, model, form);
		}
		
		InvoiceDetails invoiceDetails = modelMapper.map(form, InvoiceDetails.class);
		invoiceDetailsService.signupInvoiceDetails(invoiceDetails);
		
		log.info(form.toString());
		// Redirect to login screen
		return "redirect:/invoiceDetails/list";
	}
}
