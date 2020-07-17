package io.github.mokaim.controller;

import java.io.DataInputStream;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import io.github.mokaim.mapper.TestMapperImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class TestController_02 {

	
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
	public String ajaxTestAzure(MultipartFile[] uploadFile) {
		log.info("update ajax post-=======================");
		
		boolean validate = azureBlob.azureImageUpload(uploadFile);
		
		if(validate == true) {
			return "complete!!";
		}else {
			return "false";
		}
	
		
	}
	
	
	
	
	
}
