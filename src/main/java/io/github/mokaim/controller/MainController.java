package io.github.mokaim.controller;

import io.github.mokaim.auth.CurrentUserCheck;
import io.github.mokaim.domain.TestUser;
import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.service.CountServiceImpl;
import io.github.mokaim.service.ViewServiceImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class
MainController {

	
	@Setter(onMethod_ = @Autowired)
	ViewServiceImpl viewService;

	@Setter(onMethod_ = @Autowired)
	CountServiceImpl countService;


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
	public String main(Model model, Principal principal, @RequestParam(required = false, name = "page") String page){

		if(principal != null){
			model.addAttribute("user", principal.getName());
		}

		List<ViewInfoDTO> list;
		List<Integer> pagingList = new ArrayList<>();

		////

		String str_page = Optional.ofNullable(page)
				.filter(o -> o != null).orElse("1");



		int postCount = countService.count_Post();
		log.info("postTotal : " + postCount);
		int subPostCount = 0;
		int init_page = 0;

		int pagingNumber = (postCount / 5) + 1;


		/*
		 * for(int i=1; i<=pagingNumber; i++) { pagingList.add(i); }
		 */

		try {


			init_page = Integer.parseInt(str_page);


			if(pagingNumber < 5){

				for (int i = 1; i <= pagingNumber; i++) {
					pagingList.add(i);
				}

			}else{

				if ((init_page - 2) <= 0) {

					for (int i = 1; i <= 5; i++) {
						pagingList.add(i);
					}

				} else if (init_page >= (pagingNumber - 2)) {

					for (int i = pagingNumber - 4; i <= pagingNumber; i++) {
						pagingList.add(i);
					}

				} else {

					for (int i = init_page - 2; i <= (init_page + 2); i++) {
						pagingList.add(i);
					}

				}
			}


			subPostCount = postCount - (init_page - 1) * 5;
			list = viewService.select_PagingList(subPostCount);

		}catch (NumberFormatException e){
			log.warn("잘못된 페이지 번호 입력");
			return "redirect:/main";
		}

		////

		model.addAttribute("list",list);
		model.addAttribute("pagingNumber",pagingList);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPage",pagingNumber);


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
