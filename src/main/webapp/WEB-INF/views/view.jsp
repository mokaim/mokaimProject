<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shutter &mdash; Colorlib Website Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="_csrf" content="${_csrf.token}"/>
      <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/comments.css">


      <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    
  </head>
  <body>

  <script>
      $(function(){

          show('testparam', function(){}, 'testerr');

      });
  </script>


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
            <a href="/">MOKAIM PROJECT</a>
        </div>

        <div class="d-inline-block d-xl-none ml-md-0 ml-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white">
            <span class="icon-menu h3"></span></a></div>

        <div class="main-menu">
            <ul class="js-clone-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/main">Main</a></li>
                <li><a href="/write">Write</a></li>
            </ul>
            <ul class="social js-clone-nav">
                <li><a href="javascript:void(0);" onclick="deletePost(); return false;"><span class="icon-facebook"></span></a></li>
                <li><a href="#"><span class="icon-twitter"></span></a></li>
                <li><a href="#"><span class="icon-instagram"></span></a></li>
            </ul>
        </div>
    </header>
    <main class="main-content">
        <div class="container-fluid photos">
            <div class="row justify-content-center">


                <div class="col-md-9 pt-4">

                    <p><h2 class="text-white mb-4" data-aos="fade-up">${view._post_title}</h2></p>

                    <div class="row" data-aos="fade-up">
                        <div class="col-md-12">
                            ${view._post_content}
                        </div>
                    </div>


                     <c:forEach var="viewInfoDTO" items="${imgList}">

                        <c:if test="${viewInfoDTO._img_location != null}">

                            <figure class="mb-5" data-aos="fade-up">
                                <img src="${viewInfoDTO._img_location}" alt="Image" class="img-fluid">
                            </figure>

                        </c:if>


                     </c:forEach>



                </div>



            </div>
        </div>


        <div class="container-fluid mt-5">

            <div class="row justify-content-center">
                <div class="col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9">
                    <div class="border-bottom"></div>
                </div>
            </div>




            <div class="row justify-content-center mt-5">
                <div class="col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9">
                    <form id="commentsForm">
                        <div class="form-group">
                            <textarea class="form-control" name="comment" placeholder="댓글을 입력하세요"></textarea>
                            <input type="hidden" name="_usr_email" value="admin">
                        </div>
                        <div class="row justify-content-end">
                            <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                                <button type="button" class="btn btn-dark btn-block" id="submit_btn" onclick="send()">
                                    전송
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>



            <div class="row mt-5 justify-content-center">
                <div class="col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9">
                    <div class="row justify-content-start">
                        <div class="col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9">
                            <div class="row justify-content-center" data-aos="fade-up">
                                <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                    <ul class="p-0">
                                        <div id="target"></div>

                                    </ul>
                                </div>
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
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i>
                    by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
            </div>
        </div>


        <script>

            function send() {

                var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");

                $.ajax({
                    type: 'POST',
                    url: '/view/${view._post_num}',
                    beforeSend : function(xhr)
                    {
                        xhr.setRequestHeader(header, token);
                    },
                    data: $("#commentsForm").serialize(),

                    success: function (data) {
                        show('testparam', function(){}, 'testerr');
                    }
                })
            }

            function show(param, callback, error) {
                var html = [];

                $.getJSON(
                    '/view/${view._post_num}/comments-reply',
                    (data) => {

                        var before_comments_id = 0;

                        for(i=0; i<data.length; i++){


                            var comments_id = data[i].comments_id;
                            var reply_comments_id = data[i].reply_comments_id;

                            if(comments_id != before_comments_id){

                                before_comments_id = comments_id;

                                html.push("<li>" + "<div class='row comments mb-3'>" + "<div class='col-1 usr-img'>");
                                html.push("<img class='rounded-circle' src='http://nicesnippets.com/demo/man02.png'>" + "</div>" + "<div class='col-11 comment text-white'>");
                                html.push("<h4 class='d-inline-flex p-2'>" + data[i]._usr_email + "</h4>" +
                                    "<time>" + data[i].reg_date + "</time>" +
                                    "<p>" + data[i].comments_content + "</p>" + "</div>" + "</div>" + "</li>");

                            }


                            if(comments_id === reply_comments_id){
                                html.push("<ul class='p-0'>" +  "<li>" + "<div class='row comments mb-3'>" +
                                    "<div class='col-1 usr-img'>" +
                                    "<img class='rounded-circle' src='http://nicesnippets.com/demo/man02.png'>" +
                                    "</div>" +
                                    "<div class='col-8 reply text-white'>" +
                                    "<h4 class='d-inline-flex p-2'>" + data[i].reply_usr_email + "</h4>" +
                                    "<time class=''>" + data[i].reply_date + "</time>" +
                                    "<p>" + data[i].reply_content  + "</p>"
                                    + "</div>"

                                    +"</div>" +"</li>"+ "</ul>");

                            }
                        }

                        $('#target').html(html.join(''));



                    }


                ).fail(function (xhr, status, err) {
                    if (error) {
                        console.log("문제발생");
                        error();
                    }
                })
            }





            function deletePost(object){

                var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");

                $.ajax({

                    url : '/view/${view._post_num}',
                    type : 'delete',
                    beforeSend : function(xhr)
                    {
                        xhr.setRequestHeader(header, token);
                    },
                    success : (result) => {

                        if(result === 'success'){
                            alert('삭제 성공');
                            location.href = '/';
                        }


                    },
                    error : (err) => {

                    }


                })

            }






        </script>







    </main>


</div> <!-- .site-wrap -->











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