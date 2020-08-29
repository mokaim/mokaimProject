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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@PropertySource("classpath:/application.properties")
public class WriteController {
	

	@Autowired
	ViewServiceImpl viewService;
	
	@GetMapping("/new")
	public ModelAndView write(Principal principal, ModelAndView modelAndView) {

		String username = principal.getName();

		log.info("현재 로그인한 유저 이름 : " + username);


		modelAndView.addObject("userName", principal.getName());
		modelAndView.setViewName("write");

		return modelAndView;
	}
	
	@GetMapping("/view/{postNumber}")
	public String showView(@PathVariable("postNumber")String postNumber,Model model) {

		int num = Integer.parseInt(postNumber);
		
		log.info("test view bno : "  + postNumber);

		List<ViewInfoDTO> list = Optional.ofNullable(viewService.select_View(num)).filter(o -> o.size() > 0)
				.orElse(new ArrayList<>());

		model.addAttribute("imgList",list);
		model.addAttribute("view",list.get(0));

		return "view";
	}

	@GetMapping(value = "/view/{postNumber}/edit")
	public String showUpdateView(@PathVariable String postNumber, Model model, HttpServletResponse response) throws IOException {

		int num = 0;

		try{

			num = Integer.parseInt(postNumber);


		}catch (NumberFormatException e){
			response.sendRedirect("/");
		}


		List<ViewInfoDTO> list = Optional.ofNullable(viewService.select_View(num)).filter(o -> o.size() > 0)
				.orElse(new ArrayList<>());

		model.addAttribute("imgList",list);
		model.addAttribute("view",list.get(0));
		model.addAttribute("postNumber", postNumber);

		return "update";
	}




}
