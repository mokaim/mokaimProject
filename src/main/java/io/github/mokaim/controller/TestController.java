package io.github.mokaim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/blog")
	public String blog() {
		return "blog";
	}
	
	
	@RequestMapping("/bio")
	public String bio() {
		return "bio";
	}
	
	@RequestMapping("/contact")
	public String contect() {
		return "contact";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/photos")
	public String photos() {
		return "photos";
	}
	
	@RequestMapping("/single")
	public String single() {
		return "single";
	}
	
	
}
