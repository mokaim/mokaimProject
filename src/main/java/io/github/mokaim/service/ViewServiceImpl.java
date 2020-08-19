package io.github.mokaim.service;

import io.github.mokaim.domain.CommentsAndReplyDTO;
import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.CountMapperImpl;
import io.github.mokaim.mapper.ViewMapperImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Slf4j
@Service
public class ViewServiceImpl implements ViewService{

    @Setter(onMethod_ = @Autowired)
    ViewMapperImpl viewMapper;

    @Setter(onMethod_ = @Autowired)
    CountMapperImpl countMapper;


    @Override
    public List<ViewInfoDTO> select_View(int _post_num) {
        return viewMapper.select_View(_post_num);
    }

    @Override
    public List<ViewInfoDTO> select_List() {

        List<ViewInfoDTO> list = viewMapper.select_List();
        List<ViewInfoDTO> resultList = new ArrayList<ViewInfoDTO>();

        int before_postNumber = 0;
        int current_postNumber = 0;

        for(ViewInfoDTO viewInfoDTO : list){

            log.info("포스트 넘버 : " + viewInfoDTO.get_post_num());
            current_postNumber = viewInfoDTO.get_post_num();
            if(before_postNumber != current_postNumber){
                resultList.add(viewInfoDTO);
            }

            before_postNumber = current_postNumber;
        }



        return resultList;
    }


    @Override
    public String select_CurrentDate() {
        return viewMapper.select_CurrentDate();
    }

    @Override
    public List<CommentsDTO> select_CommentsByPostNumber(int _post_num) {
        return viewMapper.select_CommentsByPostNumber(_post_num);
    }

    @Override
    public List<CommentsAndReplyDTO> select_CommentsAndReplyByPostNumber(int _post_num) {
        return viewMapper.select_CommentsAndReplyByPostNumber(_post_num);
    }


}
