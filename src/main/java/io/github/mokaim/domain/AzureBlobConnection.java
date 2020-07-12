package io.github.mokaim.domain;

import java.io.File;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class AzureBlobConnection {

	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=mokaimblob;AccountKey=C7pttqSC3el0UPA2zl2UbPHkEnCT7ft0J5+c3FeMcIflUxnvoOQqgJaQxFmNJ38HL2CR7gvZ9+dttJwJxt2uFw==;EndpointSuffix=core.windows.net";
	
	CloudStorageAccount storageAccount;
	CloudBlobClient blobClient = null;
	CloudBlobContainer container=null;
	
	/*
	public void connectionBlob() {
		
		
		try {
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			blobClient = storageAccount.createCloudBlobClient();
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			container = blobClient.getContainerReference("mokaim-container");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Creating container: " + container.getName());
		
		
				
		try {
			
			container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
			
		
		
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		CloudBlockBlob blob = null;
		
		try {
			blob = container.getBlockBlobReference(file.getName());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		blob.getProperties().setContentType("image/jpeg"); 
		//https://stackoverflow.com/questions/10040403/set-content-type-of-media-files-stored-on-blob 
		//파일 타입을 저 형식으로 불러옴
		
		
		
		
		
		
	}
	*/
	
	
	
}
