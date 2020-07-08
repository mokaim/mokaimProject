package io.github.mokaim.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import io.github.mokaim.domain.TestDTO;


public interface TestMapper {

	public int testCount();
	
	public void testInsert(TestDTO testDTO);
	
	public List<TestDTO> testList();
	
}
