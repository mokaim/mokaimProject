<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shutter &mdash; Colorlib Website Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/aos.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/fancybox.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    
    
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>

  </head>
  <body>


  <div class="site-wrap">

  <div class="site-mobile-menu">
    <div class="site-mobile-menu-header">
      <div class="site-mobile-menu-close mt-3">
        <span class="icon-close2 js-menu-toggle"></span>
      </div>
    </div>
    <div class="site-mobile-menu-body"></div>
  </div>

  <header class="header-bar d-flex d-lg-block align-items-center" data-aos="fade-left">
    <div class="site-logo">
      <a href="index.html">Shutter</a>
    </div>

    <div class="d-inline-block d-xl-none ml-md-0 ml-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

    <div class="main-menu">
      <ul class="js-clone-nav">
        <li><a href="/">Home</a></li>
        <li><a href="/main">Main</a></li>
        <li class="active"><a href="/post">Write</a></li>
      </ul>
      <ul class="social js-clone-nav">
        <li><a href="#"><span class="icon-facebook"></span></a></li>
        <li><a href="#"><span class="icon-twitter"></span></a></li>
        <li><a href="#"><span class="icon-instagram"></span></a></li>
      </ul>
    </div>
  </header>
  <main class="main-content">
    <div class="container-fluid photos">
      <div class="row justify-content-center">

        <div class="col-md-6 pt-4"  data-aos="fade-up">
          <h2 class="text-white mb-4">스토리 집필하기!</h2>

          <div class="row">
            <div class="col-md-12">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur <a href="#">adipisicing</a> elit. Ipsa explicabo quasi cum, laudantium neque at veniam itaque atque <a href="#">necessitatibus</a> temporibus! Beatae sit soluta magni neque autem, suscipit dolorem, quo alias.</p>


              <div class="row">
                <div class="col-md-12">

                  <form>

                    <div class="row form-group">

                      <div class="col-md-12">
                        <label class="text-white" for="subject">Subject</label>
                        <input type="text" id="subject" class="form-control" name="subject">
                      </div>
                    </div>

                    <div class="row form-group mb-5">
                      <div class="col-md-12">
                        <label class="text-white" for="message">Story</label>
                        <textarea name="story" id="message" cols="30" rows="7" class="form-control" placeholder="Write your notes or questions here..."></textarea>
                      </div>
                    </div>


                    <div class="row form-group mb-5">
                      <div class="col-md-12">
                        <div class="custom-file">
                          <input type="file" class="custom-file-input" id="fileInput" name="uploadFile" multiple>
                          <label class="custom-file-label" for="fileInput">사진을 업로드 해주세요.</label>
                        </div>
                      </div>
                    </div>


                    <div class="row justify-content-center mt-5 mb-5" id="img_message" style="display: none">
                      <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-lg-12">
                        <div class="alert alert-warning">
                          반드시 한 개의 이미지를 업로드 해주세요.
                        </div>
                      </div>
                    </div>




                    <div class="row form-group">
                      <div class="col-md-12">
                        <button type="button" class="btn btn-outline-light btn-md btn-block" id="toUpload">Send Message</button>
                      </div>
                    </div>


                  </form>
                </div>

              </div>
            </div>
          </div>
        </div>

      </div>

      <div class="row justify-content-center">
        <div class="col-md-12 text-center py-5">
          <p>
        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
      </p>
        </div>
      </div>
    </div>
  </main>

</div> <!-- .site-wrap -->


	
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
          
        	
        	
        	
          $("#toUpload").on("click", function(){
            var formData = new FormData();
            
            
            var inputFile = $("input[name='uploadFile']");
            var subject = $("input[name='subject']").val();
            var story = $("textarea[name='story']").val();
            
            var files = inputFile[0].files;

            console.log(files);

            
            formData.append("title",subject);
            formData.append("content",story);
            
            for(var i = 0; i < files.length; i++){
            	
              if(!checkExtension(files[i].name, files[i].size)){
 
            	  return false;
              }
              
              formData.append("uploadFile", files[i]);
            }
            
            
            console.log(formData);

            $.ajax({
              url : '/post',
              processData : false,
              contentType : false,
              data : formData,
              type : 'POST',
              success : function(result){
                alert("업로드 완료!!");
                window.location.href="/";
              }

            }).fail(function(){
              $('#img_message').css('display', 'block');
            });

          });
        });

      </script>


	






  <script src="${pageContext.request.contextPath}/static/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.stellar.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.countdown.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap-datepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/aos.js"></script>

  <script src="${pageContext.request.contextPath}/static/js/jquery.fancybox.min.js"></script>

  <script src="${pageContext.request.contextPath}/static/js/main.js"></script>

  </body>
</html>
