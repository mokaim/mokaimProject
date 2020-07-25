package io.github.mokaim.service;

import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.PostDTO;
import io.github.mokaim.mapper.PostMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
