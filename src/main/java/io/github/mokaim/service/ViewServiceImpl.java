package io.github.mokaim.service;

import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.ViewMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService{

    @Autowired
    ViewMapperImpl viewMapper;


    @Override
    public ViewInfoDTO select_View(int _post_num) {
        return viewMapper.select_View(_post_num);
    }

    @Override
    public List<ViewInfoDTO> select_List() {
        return viewMapper.select_List();
    }


    @Override
    public String select_CurrentDate() {
        return viewMapper.select_CurrentDate();
    }

    @Override
    public List<CommentsDTO> select_CommentsByPostNumber(int _post_num) {
        return viewMapper.select_CommentsByPostNumber(_post_num);
    }
}
