package io.github.mokaim.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mokaim.domain.TestDTO;
import io.github.mokaim.mapper.TestMapperImpl;

@RestController
public class TestController_02 {

	@Autowired
	TestMapperImpl testMapperImple;
	
	@PostMapping("/testwrite")
	public String input(HttpServletRequest request) {
		
		String a_str = request.getParameter("id");
		int a = Integer.parseInt(a_str);
		String b = request.getParameter("name");
		
		TestDTO testDTO = new TestDTO();
		testDTO.setId(a);
		testDTO.setName(b);
		
		testMapperImple.testInsert(testDTO);
		
		return "complete!";
	}
	
	
}
