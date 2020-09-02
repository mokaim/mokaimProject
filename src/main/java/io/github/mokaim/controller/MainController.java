package io.github.mokaim.controller;

import io.github.mokaim.auth.CurrentUserCheck;
import io.github.mokaim.domain.TestUser;
import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.service.ViewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class
MainController {

	
	@Autowired
	ViewServiceImpl viewService;


	@GetMapping("/")
	public String list(Model model, Principal principal) {

		List<ViewInfoDTO> list = viewService.select_List();


		if(principal != null){
			model.addAttribute("user", principal.getName());
		}

		
		model.addAttribute("list", list);

		return "index";
	}

	@GetMapping("/main")
	public String main(Model model, Principal principal){

		if(principal != null){
			model.addAttribute("user", principal.getName());
		}

		model.addAttribute("list",viewService.select_List());

		return "main";
	}



	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/deniedpage")
	public String deniedPage(){
		return "deniedpage";
	}

	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}





}
