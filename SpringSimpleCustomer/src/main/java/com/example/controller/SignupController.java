package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
	//http://localhost:8080/user/signup
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private PasswordEncoder encoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/signup")
	public String getSignup(Model model,Locale locale,
			@ModelAttribute SignupForm form) {
		Map<String,Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap",genderMap);
		return "user/signup";
	}
	
	/** User signup process */
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale,
			@ModelAttribute @Validated(GroupOrder.class) SignupForm form,
			BindingResult bindingResult) {
		// Input check result
		if
		(bindingResult.hasErrors()) {
		// NG: Return to the user signup screen
		return getSignup(model, locale, form);
		}
		
//		String encoded = encoder.encode(form.getPassword());
		// encoded for password
		String encoded = new BCryptPasswordEncoder().encode(form.getPassword());
		form.setPassword(encoded);
		
		MUser user = modelMapper.map(form, MUser.class);
		userService.signup(user);
		
		log.info(form.toString());
		// Redirect to login screen
		return "redirect:/user/list";
	}
	/** Database-related exception handling */
	@ExceptionHandler(DataAccessException.class)
		public String dataAccessExceptionHandler(DataAccessException e, Model model) {
		// Set an empty string
		model.addAttribute("error", "");
		// Register message in Model
		model.addAttribute("message", "An exception occurred in SignupController");
		// Register HTTP error code(500) in Model
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
	}
	/** Other exception handling */
	@ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception e, Model model) {
		// Set an empty string
		model.addAttribute("error", "");
		// Register message in Model
		model.addAttribute("message", "An exception occurred in SignupController");
		// Register HTTP error code(500) in Model
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
	}

}
