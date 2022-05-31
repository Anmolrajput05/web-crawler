<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Website Crawler</title>
</head>
<body>
	<div class="container">
		<br>
		<h3>
			medium.com
			<c:choose>
				<c:when test="${LoggedInUser != null}">
					<p style="text-align: right;">
						Hi, ${LoggedInUser} &nbsp;&nbsp;&nbsp; <a href="/logout"
							class="btn btn-primary btn-sm mb-3 float-right"> Logout </a>
					</p>
				</c:when>
				<c:otherwise>
					<a href="/login" class="btn btn-primary btn-sm mb-3 float-right">
						Login </a>
				</c:otherwise>
			</c:choose>
		</h3>
		<hr>
		${Article.fullBlog}
	</div>
</body>
</html>

