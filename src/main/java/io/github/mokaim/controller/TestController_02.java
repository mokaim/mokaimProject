package io.github.mokaim.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.github.mokaim.domain.TestDTO;
import io.github.mokaim.mapper.TestMapperImpl;

@RestController
public class TestController_02 {

	private static Logger log = LoggerFactory.getLogger(TestController_02.class);
	
	@Autowired
	TestMapperImpl testMapperImple;
	
	@PostMapping("/testwrite")
	public String input(HttpServletRequest request) {
		
		String a_str = request.getParameter("id");
		int a = Integer.parseInt(a_str);
		String b = request.getParameter("name");
		
		TestDTO testDTO = new TestDTO();
		testDTO.setId(a);
		testDTO.setName(b);
		
		testMapperImple.testInsert(testDTO);
		
		return "complete!";
	}
	
	@PostMapping("/uploadTest")
	public String ajaxTest(MultipartFile[] uploadFile) {
		log.info("update ajax post-=======================");
		
		String uploadFolder = "D:\\ajaxUpload";
		
		for(MultipartFile multipartFile : uploadFile) {
			
			log.info("=====================================");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());
			String uploadFileName = multipartFile.getOriginalFilename();
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			log.info("only file name : " + uploadFileName);
			
			File saveFile = new File(uploadFolder, uploadFileName);
			
			try {
				
				multipartFile.transferTo(saveFile);
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return "complete!!";
	}
	
	
}
