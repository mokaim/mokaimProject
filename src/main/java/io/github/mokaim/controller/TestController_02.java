package io.github.mokaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mokaim.mapper.TestMapperImpl;

@RestController
public class TestController_02 {

	@Autowired
	TestMapperImpl testMapperImple;
	
	@GetMapping("/myTest")
	public String myBatisTest() {
		
		int test = testMapperImple.testCount();
		String test_str = Integer.toString(test);
		
		return test_str;
	}
}
