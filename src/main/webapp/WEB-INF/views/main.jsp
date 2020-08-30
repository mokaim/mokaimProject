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

    <header class="header-bar d-flex d-lg-block align-items-center">
        <div class="site-logo">
            <a href="/">Shutter</a>
        </div>

        <div class="d-inline-block d-xl-none ml-md-0 ml-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

        <div class="main-menu">
            <ul class="js-clone-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/main">Main</a></li>
            </ul>
            <ul class="social js-clone-nav">
                <li><a href="/new"><i class="fas fa-pen"></i></a></li>
                <li><a href="/login"><i class="fas fa-sign-in-alt"></i></a></li>
                <li><a href="/logout"><i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
        </div>
    </header>
    <main class="main-content">
        <div class="container-fluid photos">
            <div class="row justify-content-center">

                <div class="col-md-8 pt-4">

                    <div class="row mb-5" data-aos="fade-up">
                        <div class="col-12">
                            <h2 class="text-white mb-4 text-center">My Blog</h2>
                        </div>
                    </div>

                    <div class="row">

                        <c:forEach var="viewInfoDTO" items="${list}">

                            <div class="col-md-12 mt-0" data-aos="fade-up">
                                <div class="d-flex blog-entry align-items-start">
                                    <div class="mr-5 img-wrap"><a href="#"><img src="${viewInfoDTO._img_location}" alt="Image" class="img-fluid"></a></div>
                                    <div>
                                        <h2 class="mt-0 mb-2"><a href="#">${viewInfoDTO._post_title}</a></h2>
                                        <div class="meta mb-3">${viewInfoDTO._post_usr} on ${viewInfoDTO._post_datetime}</div>
                                        <p>${viewInfoDTO._post_content}</p>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>




                        <div class="col-12 text-center">
                            <div class="custom-pagination">
                                <span>1</span>
                                <a href="#">2</a>
                                <a href="#">3</a>
                                <span>...</span>
                                <a href="#">7</a>
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