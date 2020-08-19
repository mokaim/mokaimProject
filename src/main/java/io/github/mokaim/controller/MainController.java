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
public class MainController {

	
	@Autowired
	ViewServiceImpl viewService;


	@GetMapping("/")
	public String list(Model model) {

		List<ViewInfoDTO> list = viewService.select_List();

		for(ViewInfoDTO viewInfoDTO : list){
			log.info("포스트 넘버 : " + viewInfoDTO.get_post_num());
			log.info("이미지 경로 : " + viewInfoDTO.get_img_location());
			log.info("포스트 타이틀 : " + viewInfoDTO.get_post_title());
			log.info("포스트 내용 : " + viewInfoDTO.get_post_content());

		}
		
		model.addAttribute("list", list);

		return "index";
	}

	@GetMapping("/main")
	public String main(Model model){

		model.addAttribute("list",viewService.select_List());

		return "main";
	}



	@GetMapping("/newlogin")
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
