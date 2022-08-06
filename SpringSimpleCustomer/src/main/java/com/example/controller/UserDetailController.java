package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.UserDetailForm;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	
	/** Display user dietils screen */
	@GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form,Model model,
			@PathVariable("userId") String userId) {
		MUser user= userService.getUserOne(userId);
		user.setPassword(null);
		form = modelMapper.map(user, UserDetailForm.class);
		
		form.setSalaryList(user.getSalaryList());
		
		model.addAttribute("userDetailForm", form);
		return "user/detail";
	}
	/** User update process */
	@PostMapping(value= "/detail", params = "update")
	public String updateUser(UserDetailForm form,Model model) {
		// encoded for password
//		String encoded = new BCryptPasswordEncoder().encode(form.getPassword());
		// update user
		userService.updateUserOne(form.getUserId(), 
				form.getPassword(), 
				form.getUserName());
		return "redirect:/user/list";
	}
	
	/** User delete process */
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUser(UserDetailForm form, Model model) {
	// Delete user
	userService.deleteUserOne(form.getUserId());
	// Redirect to user list screen
	return "redirect:/user/list";
	}

}
