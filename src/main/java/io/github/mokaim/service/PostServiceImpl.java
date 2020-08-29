package io.github.mokaim.service;

import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.PostDTO;
import io.github.mokaim.mapper.PostMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostMapperImpl postMapper;


    @Override
    public void insert_img_TB(ImageDTO imageDTO) {
        postMapper.insert_img_TB(imageDTO);
    }

    @Override
    public void insert_post_TB(PostDTO postDTO) {
        postMapper.insert_post_TB(postDTO);
    }

    @Override
    public void insert_Comments(CommentsDTO commentsDTO) {
        postMapper.insert_Comments(commentsDTO);
    }

    @Transactional
    @Override
    public void updatePost(PostDTO postDTO) {
        postMapper.updatePost(postDTO);
        postMapper.deletePostImage(postDTO.get_post_num());


    }


    @Override
    public PostDTO select_PostUser(PostDTO postDTO) {
        return postMapper.select_PostUser(postDTO);
    }

}
