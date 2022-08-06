package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.InvoiceDetails;
import com.example.domain.user.service.InvoiceDetailsService;
import com.example.form.InvoiceDetailsDetailForm;

@Controller
@RequestMapping("/invoiceDetails")
public class InvoiceDetailsDetailController {
	@Autowired
	private InvoiceDetailsService invoiceDetailsService;
	@Autowired
	private ModelMapper modelMapper;
	
	/** Display user dietils screen */
	@GetMapping("/detail/{invoiceDetailsId:.+}")
	public String getInvoiceDetails(InvoiceDetailsDetailForm form,Model model,
			@PathVariable("invoiceDetailsId") Integer invoiceDetailsId) {
		InvoiceDetails invoiceDetails= invoiceDetailsService.getInvoiceDetailsOne(invoiceDetailsId);
		form = modelMapper.map(invoiceDetails, InvoiceDetailsDetailForm.class);
		
		model.addAttribute("invoiceDetailsDetailForm", form);
		return "invoiceDetails/detail";
	}
	/** User update process */
	@PostMapping(value= "/detail", params = "update")
	public String updateInvoiceDetails(InvoiceDetailsDetailForm form,Model model) {
		invoiceDetailsService.updateInvoiceDetailsOne(form.getInvoiceDetailsId(),
				form.getCustomerId(), 
				form.getMerchandiseId(),
				form.getInDate(),
				form.getAmountInvoice(),
				form.getTotalMoney());
		return "redirect:/invoiceDetails/list";
	}
	
	/** User delete process */
	@PostMapping(value = "/detail", params = "delete")
	public String deleteInvoiceDetails(InvoiceDetailsDetailForm form, Model model) {
	// Delete user
	invoiceDetailsService.deleteInvoiceDetailsOne(form.getInvoiceDetailsId());
	// Redirect to user list screen
	return "redirect:/invoiceDetails/list";
	}
}
