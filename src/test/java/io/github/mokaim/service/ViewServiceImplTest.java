package io.github.mokaim.service;

import io.github.mokaim.domain.ViewInfoDTO;
import io.github.mokaim.mapper.CountMapperImpl;
import io.github.mokaim.mapper.ViewMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ViewServiceImplTest {


    @Autowired
    CountMapperImpl countMapper;

    @Autowired
    ViewMapperImpl viewMapper;

    List<ViewInfoDTO> list;
    Integer a = 1;
    int b = 1;

    @Before
    void setUp(){

    }


    @Test
    void serviceTest(){

        //assertEquals(1, countMapper.count_Distinct_img(1));

        System.out.println(a + b);
    }


    @Test
    void select_List() {

        list = viewMapper.select_View(11);

        assertEquals(11, list.get(2).get_post_num());
    }



    @Test
    void select_PagingList() {

        list = viewMapper.select_PagingList(10);

        for (ViewInfoDTO viewInfoDTO : list) {
            System.out.println("postTitle : " + viewInfoDTO.get_post_title());
        }
    }



}