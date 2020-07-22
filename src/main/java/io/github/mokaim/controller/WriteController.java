package io.github.mokaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.mokaim.domain.TestImageDTO;
import io.github.mokaim.mapper.TestMapperImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class WriteController {
	
	
	@Autowired
	TestMapperImpl testMapperImpl;
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@GetMapping("/view/{bno}")
	public String showView(@PathVariable("bno") int bno,Model model) {
		
		
		log.info("test view bno : "  + bno);
		
		TestImageDTO testImageDTO =  testMapperImpl.view(bno);
		model.addAttribute("view",testImageDTO);

		return "view";
	}

}
