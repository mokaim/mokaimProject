package io.github.mokaim.controller;

import java.io.DataInputStream;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.microsoft.azure.storage.file.FileInputStream;

import io.github.mokaim.azure.AzureBlob;
import io.github.mokaim.domain.TestDTO;
import io.github.mokaim.domain.TestImageDTO;
import io.github.mokaim.domain.WriteDTO;
import io.github.mokaim.mapper.TestMapperImpl;
import io.github.mokaim.mapper.WriteMapperImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class TestController_02 {

	@Autowired
	WriteMapperImpl writeMapperImpl;
	
	@Autowired
	TestMapperImpl testMapperImple;
	
	@Autowired
	AzureBlob azureBlob;

	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=mokaim;AccountKey=8YblAa2df/wFk+mqBzMJlTHio0ioNUCaolHo4XPYfVWADY+G+kYfw+Vz4736YlXXexGVLUK3WDvKdr3CDUje+A==;EndpointSuffix=core.windows.net";
	
	
	
	@PostMapping("/testwrite")
	public String input(HttpServletRequest request) {
		
		String a_str = request.getParameter("id");
		int a = Integer.parseInt(a_str);
		String b = request.getParameter("name");
		

		

		
		return "complete!";
	}
	
	@PostMapping("/uploadTest1")
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
	
	
	@PostMapping("/uploadTest")
	public String ajaxTestAzure(@RequestParam("subject") String subject,
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
	
	@GetMapping("/jsonTest")
	public List<TestDTO> testJson(){
		
		
		List<TestDTO> list = new ArrayList<TestDTO>();
		
		for(int i=0; i<10; i++) {
			TestDTO testDTO = new TestDTO();
			list.add(testDTO);
		}
		
		return list;	
		
	}
	
	
	@PostMapping("/formdataAction")
	public String ajaxFormDataTest(@RequestParam("test1")String test,  @RequestParam("") MultipartFile uploadFile) {
		log.info("update ajax post-=======================");
		
		//log.info("subject : " + subject.getSubject());
		
		log.info("test file name : " + uploadFile.getOriginalFilename());
		log.info("test input name : " + test);
		
		
		return "dd";
	
		
	}
	
	
	
	
	
	
	
}
