package io.github.mokaim.mapper;

import java.util.List;


import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.PostDTO;

public interface PostMapper {

	
	public void insert_img_TB(ImageDTO imageDTO);

	
	public void insert_post_TB(PostDTO postDTO);


	public void insert_Comments(CommentsDTO commentsDTO);


	public void updatePost(PostDTO postDTO);


	public void deletePostImage(int imgSource);

	public PostDTO select_PostUser(PostDTO postDTO);

	public void deletePost(int postNumber);


}
