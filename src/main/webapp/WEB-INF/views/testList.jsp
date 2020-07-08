<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

		<div class="container-fluid text-center">
		<div class="row mt-5">

      		<div class="col-md-3 col-lg-3">

			</div>

			<div class="col-12 col-sm-12 col-md-6 col-lg-6">
				<table class="table table-dark">
					<thead>
						<tr>
							<th>id</th>
							<th>name</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="list" items="${list}">
					
						<tr>
							<td>${list.id}</td>
							<td>${list.name}</td>
						</tr>
						
						</c:forEach>
					</tbody>
				</table>
			</div>

      		<div class="col-md-3 col-lg-3">

			</div>

		</div>
	</div>

</body>
</html>