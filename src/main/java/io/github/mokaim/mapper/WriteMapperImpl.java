package io.github.mokaim.mapper;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.WriteDTO;

@Repository
public class WriteMapperImpl implements WriteMapper {

	
	@Autowired
	SqlSession sqlSession;
	
	public static final String NAME_SPACE = "io.github.mokaim.mapper";
	
	@Override
	public int count_img_TB() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAME_SPACE +".count_imgTest");
	}

	@Override
	public void insert_img_TB(ImageDTO imageDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAME_SPACE + ".insert_imgTest", imageDTO);
	}

	@Override
	public List<ImageDTO> select_List() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAME_SPACE + ".select_AllList");
	}

	@Override
	public void insert_write_TB(WriteDTO writeDTO) {
		System.out.println(writeDTO.getBno());
		System.out.println(writeDTO.getTitle());
		System.out.println(writeDTO.getStory());
		sqlSession.insert(NAME_SPACE + ".insert_writeTest", writeDTO);
		
	}

	@Override
	public int count_write_TB() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAME_SPACE + ".count_writeTest");
	}

}
