package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.user.model.Merchandise;
import com.example.domain.user.service.MerchandiseService;

@Controller
@RequestMapping("merchandise")
public class SearchMerchandiseController {
	@Autowired
	private MerchandiseService service;
	
	@GetMapping("/search")
	public String getSearchMerchandise(@ModelAttribute("merchandise") Merchandise merchandise, Model model) {
		List<Merchandise> merchandiseListId = service.getMerchandises();
		List<Merchandise> merchandiseListFind = service.getMerchandises();
		model.addAttribute("merchandiseListFind", merchandiseListFind);
		model.addAttribute("merchandiseListId", merchandiseListId);
		return "merchandise/search";
	}

	@PostMapping("/search")
	public String postSearchMerchandise(@ModelAttribute("merchandise") Merchandise merchandise, Model model) {
		List<Merchandise> merchandiseListId = service.getMerchandises();
		List<Merchandise> merchandiseListFind = service.findByMerchandise(merchandise.getMerchandiseId());
		model.addAttribute("merchandiseListId", merchandiseListId);
		model.addAttribute("merchandiseListFind", merchandiseListFind);
		return "merchandise/search";
	}
}
