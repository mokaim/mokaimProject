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
        List<ViewInfoDTO> result_list = new ArrayList<ViewInfoDTO>();
        Map<Integer, ViewInfoDTO> map = new HashMap<>();

        for(ViewInfoDTO viewInfoDTO : list){
            int postNumber = viewInfoDTO.get_post_num();
            int img_count = countMapper.count_Distinct_img(postNumber);

            if(img_count > 1){
                if(map.containsKey(postNumber)){

                }else{

                    map.put(postNumber, viewInfoDTO);
                }

            }else{
                map.put(postNumber, viewInfoDTO);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        for(int key : map.keySet()){
            result_list.add(map.get((map.size() + 1) - key));
        }


      /*  List<ViewInfoDTO> list = new ArrayList<ViewInfoDTO>();

        viewMapper.select_List().stream().filter(viewInfoDTO ->
                countMapper.count_Distinct_img(viewInfoDTO.get_post_num()) <= 1).forEach(viewInfoDTO ->
                list.add(viewInfoDTO));
      */

        return result_list;
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
