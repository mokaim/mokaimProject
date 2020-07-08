package io.github.mokaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.mokaim.mapper.TestMapperImpl;

@Controller
public class TestController {

	@Autowired
	TestMapperImpl testMapperImpl;
	
	@GetMapping("/testlist")
	public String getList(Model model) {
		
		
		model.addAttribute("list",testMapperImpl.testList());
		
		return "testList";
	}
	
	@GetMapping("/testwrite")
	public String showWrite() {
		return "testWrite";
	}

	
	
}
