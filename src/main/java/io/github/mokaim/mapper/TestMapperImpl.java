package io.github.mokaim.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

}
