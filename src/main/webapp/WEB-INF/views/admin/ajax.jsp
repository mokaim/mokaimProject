<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


  </head>
  
  <body>

    <div class="container-fluid mt-5">
      <div class="row justify-content-center">


        <div class="col-12 col-sm-12 col-md-9 col-lg-6">
          <div class="card">
            <div class="card-header">
              Title
            </div>

            <div class="card-body">
              <form method="post">
                  <div class="form-group">
                      <label for="test">테스트 네임</label>
                      <input type="text" name="" value="" id="test" class="form-control">
                 </div>

                 <div class="custom-file">
                   <input type="file" class="custom-file-input" id="customFile" name="uploadFile">
                  <label class="custom-file-label" for="customFile">Choose file</label>

                 </div>

                 <button type="button" class="btn btn-primary form-control mt-3" name="" id="submit_btn">전송!!</button>

              </form>
            </div>

            <div class="card-footer">
              footer
            </div>
          </div>


        </div>

      </div>


      <script type="text/javascript">
     
      
      

        $(document).ready(function(){
        	
        	
            
          	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|7z)$");
          	var maxSize = 5782934;
          	
          	function checkExtension(fileName, fileSize){
          		if(fileSize >= maxSize){
                 	alert("파일 용량이 너무큽니다..");
          			return false;
          		}
          		
          		if(regex.test(fileName)){
          			alert("해당 종류의 파일은 업로드 할 수 없습니다.. 이미지만 올려주세요..;;");
          			return false;
          		}
          		
          		return true;
          	}
          
        	
        	
        	
          $("#submit_btn").on("click", function(){
            var formData = new FormData();
            var inputFile = $("input[name='uploadFile']");
            var files = inputFile[0].files;

            console.log(files);

            for(var i = 0; i < files.length; i++){
            	
              if(!checkExtension(files[i].name, files[i].size)){
 
            	  return false;
              }
              
              formData.append("uploadFile", files[i]);
            }

            $.ajax({
              url : '/uploadTest',
              processData : false,
              contentType : false,
              data : formData,
              type : 'POST',
              success : function(result){
                alert("업로드 완료!!");
                window.location.href="/list";
              }

            });

          });
        });

      </script>



    </div>

  </body>
</html>
