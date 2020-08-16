<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Shutter &mdash; Colorlib Website Template</title>
    <meta charset="utf-8">
</head>
<body>

<center>
    <h1>Welcome to Spring Boot Security</h1>

    <h2>여긴 로그인페이지 ㅋㅋ</h2>

    <form method="POST" action="/loginpro">
        User Name : <input type="text" name="username" value="user"/><br><br>
        Password  : <input type="password" name="password"/><br><br>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="전송">
    </form>
</center>

</body>
</html>
