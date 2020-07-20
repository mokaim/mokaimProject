package io.github.mokaim.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import io.github.mokaim.domain.TestDTO;
import io.github.mokaim.domain.TestImageDTO;

@Service
public class TestMapperImpl implements TestMapper{
	
	@Autowired
	SqlSession sqlSession;
	
	public static final String NAME_SPACE = "io.github.mokaim.mapper";



	@Override
	public void insert_imgTest(TestImageDTO testImageDTO) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(NAME_SPACE + ".insert_imgTest", testImageDTO);
		
	}


	
	@Override
	public int count_imgTest() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(NAME_SPACE +".count_imgTest");
	}



	@Override
	public List<TestImageDTO> list() {
		// TODO Auto-generated method stub
		
		
		
		
		return sqlSession.selectList(NAME_SPACE + ".select_AllList");
	}



	@Override
	public TestImageDTO view(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAME_SPACE + ".select_viewTest",bno);
	}
	
	
	
	
	
	

}
