package io.github.mokaim.service;

import io.github.mokaim.domain.CommentsAndReplyDTO;
import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.CountMapperImpl;
import io.github.mokaim.mapper.ViewMapperImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class ViewServiceImpl implements ViewService{

    @Setter(onMethod_ = @Autowired)
    ViewMapperImpl viewMapper;

    @Setter(onMethod_ = @Autowired)
    CountMapperImpl countMapper;


    @Override
    public ViewInfoDTO select_View(int _post_num) {
        return viewMapper.select_View(_post_num);
    }

    @Override
    public List<ViewInfoDTO> select_List() {

        List<ViewInfoDTO> list = viewMapper.select_List();
        List<ViewInfoDTO> result_list = new ArrayList<ViewInfoDTO>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();


        for(ViewInfoDTO viewInfoDTO : list){
            if(!(hashMap.containsKey(viewInfoDTO.get_post_num()))){
                hashMap.put(viewInfoDTO.get_post_num(),1);
            }
        }

/*
        List<ViewInfoDTO> list = new ArrayList<ViewInfoDTO>();

        viewMapper.select_List().stream().filter(viewInfoDTO -> countMapper.count_Distinct_img(viewInfoDTO.get_post_num()) <= 1).forEach(viewInfoDTO -> list.add(viewInfoDTO));
*/

        return list;
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
