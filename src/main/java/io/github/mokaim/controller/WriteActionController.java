package io.github.mokaim.controller;

import io.github.mokaim.azure.AzureBlob;
import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.PostDTO;
import io.github.mokaim.service.PostServiceImpl;
import io.github.mokaim.service.ViewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping("/post")
    public String from_ajax_to_AzureStorage(@RequestParam("title") String title,
                                @RequestParam("content") String content ,
                                MultipartFile[] uploadFile) {

        log.info("update ajax post-=======================");

        log.info("subject : " + title);
        log.info("story : " + content);
        log.info("image Name : " +  uploadFile[0].getOriginalFilename());

        PostDTO postDTO = new PostDTO();


        postDTO.set_post_title(title);
        postDTO.set_post_content(content);

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
            @PathVariable("postNumber")  int postNumber,
            @RequestParam("comment") String comment,
            @RequestParam("_usr_email") String _usr_email
    ){


        log.info("postNumber : " + postNumber);
        log.info("comment : " + comment);
        log.info("_usr_email : " + _usr_email);

        CommentsDTO commentsDTO = new CommentsDTO();
        commentsDTO.setComments_content(comment);
        commentsDTO.set_usr_email(_usr_email);
        commentsDTO.set_post_num(postNumber);
        commentsDTO.setReg_date("2020-07-26");

        postService.insert_Comments(commentsDTO);

        log.info("===============================Success=================== ");

        return "success";
    }


    @GetMapping("/view/{postNumber}/comments")
    public List<CommentsDTO> getCommentsList(@PathVariable int postNumber){
        return viewService.select_CommentsByPostNumber(postNumber);
    }

}
