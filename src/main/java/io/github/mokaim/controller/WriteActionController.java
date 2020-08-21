package io.github.mokaim.controller;

import io.github.mokaim.azure.AzureBlob;
import io.github.mokaim.domain.CommentsAndReplyDTO;
import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.PostDTO;
import io.github.mokaim.service.PostServiceImpl;
import io.github.mokaim.service.ViewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
public class WriteActionController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    ViewServiceImpl viewService;  //getCurrentDate

    @Autowired
    AzureBlob azureBlob;

    @Transactional
    @PostMapping("/mymy")
    public String from_ajax_to_AzureStorage(@RequestParam("title") String title,
                                            @RequestParam("content") String content ,
                                            Principal principal,
                                            MultipartFile[] uploadFile) {

        String username = principal.getName();

        log.info("update ajax post-=======================");

        log.info("subject : " + title);
        log.info("story : " + content);
        log.info("image Name : " +  uploadFile[0].getOriginalFilename());
        log.info("현재 글을 작성한 유저 이름 : " + username);

        PostDTO postDTO = new PostDTO();


        postDTO.set_post_title(title);
        postDTO.set_post_content(content);
        postDTO.set_post_usr(username);


        boolean validate = false;

        try{

            postService.insert_post_TB(postDTO);
            log.info("포스트 완료");
            validate = azureBlob.azureImageUpload(uploadFile);
            log.info("이미지 업로드 완료");

        }catch (Exception e){
            log.warn(e.getMessage());
        }



        if(validate == true) {
            return "complete!!";
        }else {
            return "false";
        }
    }


    @Transactional
    @PostMapping("/view/{postNumber}")
    public String from_ajax_to_Comments(
            @PathVariable("postNumber")  String postNumber,
            @RequestParam("comment") String comment,
            @RequestParam("_usr_email") String _usr_email
    ){


        int num = Integer.parseInt(postNumber);

        log.info("postNumber : " + postNumber);
        log.info("comment : " + comment);
        log.info("_usr_email : " + _usr_email);

        CommentsDTO commentsDTO = new CommentsDTO();
        commentsDTO.setComments_content(comment);
        commentsDTO.set_usr_email(_usr_email);
        commentsDTO.set_post_num(num);
        commentsDTO.setReg_date("2020-07-26");

        postService.insert_Comments(commentsDTO);

        log.info("===============================Success=================== ");

        return "success";
    }


    @GetMapping("/view/{postNumber}/comments")
    public List<CommentsDTO> getCommentsList(@PathVariable Integer postNumber){



        log.info("테스트 넘버 : " + postNumber);

        return viewService.select_CommentsByPostNumber(postNumber);
    }

    @GetMapping("/view/{postNumber}/comments-reply")
    public List<CommentsAndReplyDTO> getCommentsAndReplyList(@PathVariable Integer postNumber){


        log.info("테스트 넘버 : " + postNumber);

        return viewService.select_CommentsAndReplyByPostNumber(postNumber);
    }



}
