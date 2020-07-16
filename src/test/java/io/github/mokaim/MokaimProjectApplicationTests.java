package io.github.mokaim;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.mokaim.mapper.TestMapperImpl;

@SpringBootTest
class MokaimProjectApplicationTests {

	@Autowired
	TestMapperImpl test;
	
	@Test
	void contextLoads() {

	}

}
