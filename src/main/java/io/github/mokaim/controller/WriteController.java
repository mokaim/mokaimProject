package io.github.mokaim.controller;

import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.ViewMapperImpl;
import io.github.mokaim.service.ViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Slf4j
@Controller
@PropertySource("classpath:/application.properties")
public class WriteController {
	

	@Autowired
	ViewServiceImpl viewService;
	
	@GetMapping("/post")
	public ModelAndView write(Principal principal, ModelAndView modelAndView) {

		modelAndView.addObject("userName", principal.getName());
		modelAndView.setViewName("write");

		return modelAndView;
	}
	
	@GetMapping("/view/{postNumber}")
	public String showView(@PathVariable("postNumber")String postNumber,Model model) {

		int num = Integer.parseInt(postNumber);
		
		log.info("test view bno : "  + postNumber);

		List<ViewInfoDTO> list =  viewService.select_View(num);
		model.addAttribute("imgList",list);
		model.addAttribute("view",list.get(0));

		return "view";
	}

}
