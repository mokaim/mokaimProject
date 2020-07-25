package io.github.mokaim.controller;

import io.github.mokaim.azure.AzureBlob;
import io.github.mokaim.domain.PostDTO;
import io.github.mokaim.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class WriteActionController {

    @Autowired
    PostServiceImpl postService;

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
}
