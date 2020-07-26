package io.github.mokaim.service;

import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.PostDTO;

import java.util.List;

public interface PostService {

    public void insert_img_TB(ImageDTO imageDTO);

    public void insert_post_TB(PostDTO postDTO);

    public void insert_Comments(CommentsDTO commentsDTO);

}
