package io.github.mokaim.controller;

import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.ViewMapperImpl;
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
	ViewMapperImpl viewMapperImpl;
	
	@GetMapping("/write")
	public String write() {

		return "write";
	}
	
	@GetMapping("/view/{bno}")
	public String showView(@PathVariable("bno") int bno,Model model) {
		
		
		log.info("test view bno : "  + bno);
		
		ViewInfoDTO viewInfoDTO =  viewMapperImpl.view(bno);
		model.addAttribute("view",viewInfoDTO);

		return "view";
	}

}
