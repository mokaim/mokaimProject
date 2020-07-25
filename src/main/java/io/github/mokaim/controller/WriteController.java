package io.github.mokaim.controller;

import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.ViewMapperImpl;
import io.github.mokaim.service.ViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class WriteController {
	

	@Autowired
	ViewServiceImpl viewService;
	
	@GetMapping("/post")
	public String write() {

		return "write";
	}
	
	@GetMapping("/view/{postNumber}")
	public String showView(@PathVariable("postNumber") int postNumber,Model model) {
		
		
		log.info("test view bno : "  + postNumber);
		
		ViewInfoDTO viewInfoDTO =  viewService.select_View(postNumber);
		model.addAttribute("view",viewInfoDTO);

		return "view";
	}

}
