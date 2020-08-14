package io.github.mokaim.service;

import io.github.mokaim.mapper.CountMapperImpl;
import io.github.mokaim.mapper.ViewMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ViewServiceImplTest {


    @Autowired
    CountMapperImpl countMapper;

    @Autowired
    ViewMapperImpl viewMapper;

    @Test
    void serviceTest(){
        assertEquals(1, countMapper.count_Distinct_img(1));
    }


    @Test
    void select_List() {


    }
}