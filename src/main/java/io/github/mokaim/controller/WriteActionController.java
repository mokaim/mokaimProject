package io.github.mokaim.controller;

import io.github.mokaim.azure.AzureBlob;
import io.github.mokaim.azure.AzureUpdateBlob;
import io.github.mokaim.domain.CommentsAndReplyDTO;
import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.PostDTO;
import io.github.mokaim.service.PostServiceImpl;
import io.github.mokaim.service.ViewServiceImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class WriteActionController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    ViewServiceImpl viewService;  //getCurrentDate

    @Autowired
    AzureBlob azureBlob;

    @Setter(onMethod_ = @Autowired)
    AzureUpdateBlob azureUpdateBlob;


    @PostMapping("/new")
    public String from_ajax_to_AzureStorage(@RequestParam("title") String title,
                                            @RequestParam("content") String content ,
                                            Principal principal,
                                            MultipartFile[] uploadFile) {

        String username = principal.getName();
        boolean isImage = Optional.ofNullable(uploadFile).filter(o -> o.length > 0).isPresent();

        log.info("update ajax post-=======================");
        log.info("현재 업로드 된 이미지가 있는가 ? " + isImage);
        log.info("subject : " + title);
        log.info("story : " + content);
        //log.info("image Name : " +  uploadFile[0].getOriginalFilename());
        log.info("현재 글을 작성한 유저 이름 : " + username);

        PostDTO postDTO = new PostDTO();


        postDTO.set_post_title(title);
        postDTO.set_post_content(content);
        postDTO.set_post_usr(username);


        boolean validate = false;

        try{

            postService.insert_post_TB(postDTO);
            log.info("포스트 완료");

            if(isImage == true){
                validate = azureBlob.azureImageUpload(uploadFile);
                log.info("이미지 업로드 완료");
            }



        }catch (Exception e){
            log.warn(e.getMessage());
        }



        if(validate == true) {
            return "complete!!";
        }else {
            return "false";
        }
    }



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

    @PutMapping(value = "/view/{postNumber}/edit")
    public String updatePost(@PathVariable String postNumber,
                             Principal principal,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("uploadFile") MultipartFile[] multipartFile) throws IOException {


        int number = 0;

        log.info("업데이트 타이틀 : " + title);
        log.info("업데이트 콘텐츠 : " + content);
        log.info("업데이트 이미지 파일의 갯수 : " + multipartFile.length);
        log.info("현재 로그인 한 사용자 : " + principal.getName());
        log.info("현재 뷰 넘버는 : " + postNumber);

        try{

            number = Integer.parseInt(postNumber);
            log.info("넘버 포맷 완료!!");

        }catch (NumberFormatException e){

            return "잘못된 뷰페이지";

        }


        PostDTO postDTO = new PostDTO();
        postDTO.set_post_usr(principal.getName());
        postDTO.set_post_num(number);
        postDTO.set_post_title(title);
        postDTO.set_post_content(content);

        PostDTO result =  Optional.ofNullable(postService.select_PostUser(postDTO)).filter(o -> o != null)
                            .orElseGet(() -> {
                                PostDTO t = new PostDTO();
                                t.set_post_title("");

                                return t;
                            });

        if(!result.get_post_title().isEmpty()){
            log.info("성공적으로 회원 조회가 되었음");
            postService.updatePost(postDTO);
            azureUpdateBlob.azureImageUpload(multipartFile, postDTO.get_post_num());
            return "성공!!";


        }else{
            log.info("회원 조회 실패...;;;");
            return "회원 조회 실패";
        }


    }

}
