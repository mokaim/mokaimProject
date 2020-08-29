package io.github.mokaim.azure;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.UUID;

import io.github.mokaim.service.CountServiceImpl;
import io.github.mokaim.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

import io.github.mokaim.domain.ImageDTO;
import lombok.extern.slf4j.Slf4j;
//Azure


@Slf4j
@Component
public class AzureUpdateBlob {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    CountServiceImpl countService;


    public static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=mokaim;AccountKey=8YblAa2df/wFk+mqBzMJlTHio0ioNUCaolHo4XPYfVWADY+G+kYfw+Vz4736YlXXexGVLUK3WDvKdr3CDUje+A==;EndpointSuffix=core.windows.net";


    public boolean azureImageUpload(MultipartFile[] uploadFile, int img_source) {
        log.info("update ajax post-=======================");

        CloudStorageAccount storageAccount;
        CloudBlobClient blobClient = null;
        CloudBlobContainer container=null;
        CloudBlockBlob blob = null;
        ImageDTO imageDTO = new ImageDTO();
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




                uploadFileName = uuid + multipartFile.getOriginalFilename();
                log.info("only file name : " + uploadFileName);

                imageDTO.set_img_name(uploadFileName);
                imageDTO.set_img_location("https://mokaim.blob.core.windows.net/mokaim-container/"+uploadFileName);
                imageDTO.set_img_source(img_source);


                blob.upload(is, length);  //인풋스트림으로 파일을 업로드 시킨다.





                log.info("img_id : " + imageDTO.get_img_num());
                log.info("img_name : " + imageDTO.get_img_name());
                log.info("img_url : " + imageDTO.get_img_location());
                log.info("img source : " + imageDTO.get_img_source());


                postService.insert_img_TB(imageDTO);

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

            return true;

        }
        catch (StorageException ex)
        {
            System.out.println(String.format("Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }


        return false;
    }




}
