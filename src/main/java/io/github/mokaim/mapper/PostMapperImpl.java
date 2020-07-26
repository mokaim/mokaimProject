package io.github.mokaim.mapper;

import java.util.List;


import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.PostDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.mokaim.domain.ImageDTO;
import org.springframework.stereotype.Repository;

@Repository
public class PostMapperImpl implements PostMapper {

	
	@Autowired
	SqlSession sqlSession;
	
	public static final String NAME_SPACE = "io.github.mokaim.mapper";


	@Override
	public void insert_img_TB(ImageDTO imageDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAME_SPACE + ".insert_Img", imageDTO);
	}


	@Override
	public void insert_post_TB(PostDTO postDTO) {
		sqlSession.insert(NAME_SPACE + ".insert_Post", postDTO);
		
	}

	@Override
	public void insert_Comments(CommentsDTO commentsDTO) {
		sqlSession.insert(NAME_SPACE + ".insert_Comments", commentsDTO);
	}


}
