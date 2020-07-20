package io.github.mokaim.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.mokaim.domain.TestImageDTO;
import io.github.mokaim.mapper.TestMapperImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class TestController {

	@Autowired
	TestMapperImpl testMapperImpl;
	

	@GetMapping("/testwrite")
	public String showWrite() {
		return "testWrite";
	}
	
	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	
	@GetMapping("/list")
	public String showList(Model model) {
		
		model.addAttribute("list", testMapperImpl.list());
		
		
		return "photos";
	}
	
	@GetMapping("/formdata")
	public String testFormdata(Model model) {
		

		return "formdata";
	}
	
	
	@GetMapping("/view/{bno}")
	public String showView(@PathVariable("bno") int bno,Model model) {
		
		
		log.info("test view bno : "  + bno);
		
		TestImageDTO testImageDTO =  testMapperImpl.view(bno);
		model.addAttribute("view",testImageDTO);

		return "view";
	}
	
	
	
	
}
