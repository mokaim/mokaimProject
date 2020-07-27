package io.github.mokaim.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class WriteActionControllerTest {


    //https://ktko.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81Spring-MockMvc-%ED%85%8C%EC%8A%A4%ED%8A%B8
    //MockMVC 설명

    @Autowired
    WriteActionController writeActionController;

    MultiValueMap<String, String> test;

    MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(writeActionController).build();

    }

    @Test
    void getCommentsList() throws Exception {



        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/view/2/comments.json").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
    }


    @Test
    void from_ajax_to_Comments() throws Exception{

        test = new LinkedMultiValueMap<String, String>();
        test.add("postNumber", "2");
        test.add("comment","testtest");
        test.add("_usr_email","mokaim@naver.com");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/view/2").params(test).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
    }


}