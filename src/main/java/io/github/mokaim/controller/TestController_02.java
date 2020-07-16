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

import io.github.mokaim.domain.AzureBlobConnection;
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
	AzureBlobConnection azureBlob;
	
	
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
		
		CloudStorageAccount storageAccount;
		CloudBlobClient blobClient = null;
		CloudBlobContainer container=null;
		CloudBlockBlob blob = null;
		TestImageDTO testImageDTO = new TestImageDTO();
		InputStream is = null;
		
		String uuid = UUID.randomUUID().toString();

		
		try {    
			// Parse the connection string and create a blob client to interact with Blob storage
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference("mokaim-container");

			// Create the container if it does not exist with public access.
			System.out.println("Creating container: " + container.getName());
			container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());		    

			String uploadFileName = null;
			
			for(MultipartFile multipartFile : uploadFile) {
				
				log.info("=====================================");
				log.info("Upload File Name : " + multipartFile.getOriginalFilename());
				log.info("Upload File Size : " + multipartFile.getSize());
				
				is = new DataInputStream(multipartFile.getInputStream());
				long length = multipartFile.getSize();
				blob = container.getBlockBlobReference(uuid + multipartFile.getOriginalFilename());
				blob.getProperties().setContentType("image/jpeg");  //https://stackoverflow.com/questions/10040403/set-content-type-of-media-files-stored-on-blob 
				//블록의 기본 옥텟설정을 바꾼다.
				blob.upload(is, length);  //인풋스트림으로 파일을 업로드 시킨다.
				
				
				uploadFileName = uuid + multipartFile.getOriginalFilename();
				log.info("only file name : " + uploadFileName);
				
				testImageDTO.set_img_id(testMapperImple.count_imgTest() + 1);
				testImageDTO.set_img_name(uploadFileName);
				testImageDTO.set_img_url("https://mokaim.blob.core.windows.net/mokaim-container/"+uploadFileName);
				
				
				log.info("img_id : " + testImageDTO.get_img_id());
				log.info("img_name : " + testImageDTO.get_img_name());
				log.info("img_url : " + testImageDTO.get_img_url());
				
				testMapperImple.insert_imgTest(testImageDTO);
				

				//https://stackoverflow.com/questions/35860578/azure-storage-through-java-mvc-web-site 
				//블롭스토리지로 바로 파일업로드 처리!!
				
				
			}
			//Listing contents of container
			for (ListBlobItem blobItem : container.listBlobs()) {
				System.out.println("URI of blob is: " + blobItem.getUri());
			}

		// Download blob. In most cases, you would have to retrieve the reference
		// to cloudBlockBlob here. However, we created that reference earlier, and 
		// haven't changed the blob we're interested in, so we can reuse it. 
		// Here we are creating a new file to download to. Alternatively you can also pass in the path as a string into downloadToFile method: blob.downloadToFile("/path/to/new/file").
			
		//downloadedFile = new File(file.getParentFile(), "downloadedFile.txt");
		//blob.downloadToFile(downloadedFile.getAbsolutePath());
		} 
		catch (StorageException ex)
		{
			System.out.println(String.format("Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
		}
		catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		
	
		return "complete!!";
	}
	
	
	
	
	
}
