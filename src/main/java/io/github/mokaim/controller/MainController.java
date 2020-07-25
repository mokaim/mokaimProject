package io.github.mokaim.controller;

import io.github.mokaim.service.ViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController {

	
	@Autowired
	ViewServiceImpl viewService;
	
	
	@GetMapping("/")
	public String list(Model model) {
		
		model.addAttribute("list",viewService.select_List());
		
		return "index";
	}

}
