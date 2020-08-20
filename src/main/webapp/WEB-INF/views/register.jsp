<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <style>

        input[type=email] {
            background : transparent;
        }

    </style>



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
                <li><a href="index.html">Home</a></li>
                <li><a href="photos.html">Photos</a></li>
                <li><a href="bio.html">Bio</a></li>
                <li><a href="blog.html">Blog</a></li>
                <li class="active"><a href="contact.html">Contact</a></li>
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
                    <h2 class="text-white mb-4">Sign Up</h2>

                    <div class="row">
                        <div class="col-md-12">
                            <p class="mb-5">Please enter your information.</p>


                            <div class="row">
                                <div class="col-md-12">

                                    <form>


                                        <div class="row form-group">
                                            <div class="col-md-12">
                                                <label class="text-white" for="email">Email</label>
                                                <input type="email" id="email" class="form-control" name="email">
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col-md-12">
                                                <label class="text-white" for="password">Password</label>
                                                <input type="password" id="password" class="form-control" name="password">
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col-md-12">
                                                <label class="text-white" for="password-check">Confirm Password</label>
                                                <input type="password" id="password-check" class="form-control" name="password_check">
                                            </div>
                                        </div>

                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                        <div class="row form-group mt-5">
                                            <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-3">
                                                <button type="button" class="btn btn-primary btn-block text-white" id="sendInfo">submit</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <script>

                    $(document).ready(() => {



                        $("#sendInfo").on("click", () => {

                            var token = $("meta[name='_csrf']").attr("content");
                            var header = $("meta[name='_csrf_header']").attr("content");

                            var formData = new FormData();

                            var email = $("input[name='email']");
                            var password = $("input[name='password']");
                            var password_check = $("input[name='password_check']");

                            formData.append("email",email);
                            formData.append("password",password);
                            formData.append("password_check",password_check);


                            $.ajax({
                                url : '/register',
                                data : formData,
                                processData : false,
                                contentType : false,

                                beforeSend : function(xhr)
                                {
                                    xhr.setRequestHeader(header, token);
                                },

                                type : 'post',

                                success : (result) => {
                                    alert(result);
                                    //JSON.stringify(result)
                                }


                            }).fail((err) => {
                                alert('faild');
                            });

                        });

                    });


                </script>





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


<script src="${pageContext.request.contextPath}/static/js/jquery-migrate-3.0.1.min.js"></script>
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