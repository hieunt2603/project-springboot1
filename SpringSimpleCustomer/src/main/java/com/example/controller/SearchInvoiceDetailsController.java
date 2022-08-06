package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.user.model.InvoiceDetails;
import com.example.domain.user.model.Merchandise;
import com.example.domain.user.service.InvoiceDetailsService;

@Controller
@RequestMapping("invoiceDetails")
public class SearchInvoiceDetailsController {
	@Autowired
	private InvoiceDetailsService service;
	
	@GetMapping("/search")
	public String getSearchInvoiceDetails(@ModelAttribute("merchandise") Merchandise merchandise, Model model) {
		List<Merchandise> merchandiseList = service.getMerchandises();
		List<InvoiceDetails> invoiceDetailsList = service.getInvoiceDetails();
		model.addAttribute("merchandiseList", merchandiseList);
		model.addAttribute("invoiceDetailsList", invoiceDetailsList);
		return "invoiceDetails/search";
	}

	@PostMapping("/search")
	public String postSearchInvoiceDetails(@ModelAttribute("merchandise") Merchandise merchandise, Model model) {
		List<Merchandise> merchandiseList = service.getMerchandises();
		List<InvoiceDetails> invoiceDetailsList = service.findByMerchandise(merchandise.getMerchandiseId());
		model.addAttribute("merchandiseList", merchandiseList);
		model.addAttribute("invoiceDetailsList", invoiceDetailsList);
		return "invoiceDetails/search";
	}
}
