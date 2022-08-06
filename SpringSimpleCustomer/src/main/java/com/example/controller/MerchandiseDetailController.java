package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Merchandise;
import com.example.domain.user.service.MerchandiseService;
import com.example.form.MerchandiseDetailForm;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseDetailController {
	@Autowired
	private MerchandiseService merchandiseService;
	@Autowired
	private ModelMapper modelMapper;
	/** Display user dietils screen */
	@GetMapping("/detail/{merchandiseId:.+}")
	public String getMerchandise(MerchandiseDetailForm form,Model model,
			@PathVariable("merchandiseId") Integer merchandiseId) {
		Merchandise merchandise= merchandiseService.getMerchandiseOne(merchandiseId);
		form = modelMapper.map(merchandise, MerchandiseDetailForm.class);
		
		model.addAttribute("merchandiseDetailForm", form);
		return "merchandise/detail";
	}
	/** User update process */
	@PostMapping(value= "/detail", params = "update")
	public String updateMerchandise(MerchandiseDetailForm form,Model model) {
		merchandiseService.updateMerchandiseOne(form.getMerchandiseId(),
				form.getMerchandiseName(), 
				form.getAmount(),
				form.getMoney());
		return "redirect:/merchandise/list";
	}
	
	/** User delete process */
	@PostMapping(value = "/detail", params = "delete")
	public String deleteMerchandise(MerchandiseDetailForm form, Model model) {
	// Delete user
	merchandiseService.deleteMerchandiseOne(form.getMerchandiseId());
	// Redirect to user list screen
	return "redirect:/merchandise/list";
	}
}
