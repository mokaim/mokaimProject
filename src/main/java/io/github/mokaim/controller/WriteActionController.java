package io.github.mokaim.controller;

import io.github.mokaim.azure.AzureBlob;
import io.github.mokaim.domain.WriteDTO;
import io.github.mokaim.mapper.WriteMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class WriteActionController {

    @Autowired
    WriteMapperImpl writeMapperImpl;

    @Autowired
    AzureBlob azureBlob;

    @PostMapping("/write")
    public String from_ajax_to_AzureStorage(@RequestParam("subject") String subject,
                                @RequestParam("story") String story ,
                                MultipartFile[] uploadFile) {

        log.info("update ajax post-=======================");

        log.info("subject : " + subject);
        log.info("story : " + story);
        log.info("image Name : " +  uploadFile[0].getOriginalFilename());

        WriteDTO writeDTO = new WriteDTO();



        writeDTO.setBno(writeMapperImpl.count_write_TB() + 1);
        writeDTO.setTitle(subject);
        writeDTO.setStory(story);

        writeMapperImpl.insert_write_TB(writeDTO);

        boolean validate = azureBlob.azureImageUpload(uploadFile);

        if(validate == true) {
            return "complete!!";
        }else {
            return "false";
        }


    }
}
