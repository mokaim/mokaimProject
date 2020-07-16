package io.github.mokaim.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import io.github.mokaim.domain.TestDTO;
import io.github.mokaim.domain.TestImageDTO;


public interface TestMapper {

	public int count_imgTest();
	
	
	public void insert_imgTest(TestImageDTO testImageDTO);
	
	
	public List<TestImageDTO> list();
	
}
