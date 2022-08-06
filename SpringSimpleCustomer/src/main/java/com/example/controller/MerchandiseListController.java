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
import com.example.domain.user.model.Merchandise;
import com.example.domain.user.service.MerchandiseService;
import com.example.form.GroupOrder;
import com.example.form.MerchandiseListForm;
import com.example.form.SignupMerchandiseForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/merchandise")
@Slf4j
public class MerchandiseListController {
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private MerchandiseService merchandiseService;
	
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/list")
	public String getMerchandiseList(@ModelAttribute MerchandiseListForm form,Model model) {
		
		Merchandise merchandise = modelMapper.map(form, Merchandise.class);
		
		List<Merchandise> merchandiseList = merchandiseService.getMerchandises(merchandise);
		model.addAttribute("merchandiseList",merchandiseList);
		return "merchandise/list";
	}
	@PostMapping("/list")
	public String postMerchandiseList(@ModelAttribute MerchandiseListForm form,Model model) {
		
		Merchandise merchandise = modelMapper.map(form, Merchandise.class);
		
		List<Merchandise> merchandiseList = merchandiseService.getMerchandises(merchandise);
		model.addAttribute("merchandiseList",merchandiseList);
		return "merchandise/list";
	}
	
	@GetMapping("/add")
	public String getMerchandiseList(Locale locale,Model model,
			@ModelAttribute SignupMerchandiseForm form) {
		Map<String,Integer> merchandiseMap = userApplicationService.getMap(locale);
		model.addAttribute("merchandiseMap",merchandiseMap);
		
		return "merchandise/add";
	}
	@PostMapping("/add")
	public String postSignup(Model model, Locale locale,
			@ModelAttribute @Validated(GroupOrder.class) SignupMerchandiseForm form,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return getMerchandiseList(locale, model, form);
		}
		
		Merchandise merchandise = modelMapper.map(form, Merchandise.class);
		
//		MUser user = modelMapper.map(form, MUser.class);
//		List<MUser> userList = userService.getUsers(user);
//		
//		model.addAttribute("userList",userList);
		
		merchandiseService.signupMerchandise(merchandise);
		
		log.info(form.toString());
		// Redirect to login screen
		return "redirect:/merchandise/list";
	}
}
