package io.github.mokaim.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import io.github.mokaim.domain.TestDTO;

@Service
public class TestMapperImpl implements TestMapper{
	
	@Autowired
	SqlSession sqlSession;
	
	public static final String NAME_SPACE = "io.github.mokaim.mapper";

	@Override
	public int testCount() {
		// TODO Auto-generated method stub	
		return sqlSession.selectOne(NAME_SPACE + ".selectTest");
	}
	

	@Override
	public void testInsert(TestDTO testDTO) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(NAME_SPACE + ".insertTest",testDTO);
	}


	@Override
	public List<TestDTO> testList() {
		// TODO Auto-generated method stub

		return sqlSession.selectList(NAME_SPACE + ".selectListTest");
	}
	
	
	
	

}
