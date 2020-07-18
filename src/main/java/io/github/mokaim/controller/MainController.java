package io.github.mokaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.mokaim.mapper.WriteMapperImpl;



@Controller
public class MainController {

	
	@Autowired
	WriteMapperImpl writeMapperImpl;
	
	
	
	@GetMapping("/")
	public String list(Model model) {
		
		model.addAttribute("list",writeMapperImpl.select_List());
		
		return "index";
	}
}
