<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
    .button {
      border: none;
      color: white;
      padding: 15px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      cursor: pointer;
    }
    
    .button1 {background-color: #4CAF50;} /* Green */
    .button2 {background-color: #008CBA;} /* Blue */
    </style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Web Crawler</title>
</head>
<body>
	<div class="container">
		<br>
		<h3>
			Welcome to Website Crawler
			<c:choose>
				<c:when test="${LoggedInUser != null}">
					<p style="text-align: right;">
						Hi, ${LoggedInUser} &nbsp;&nbsp;&nbsp; <a href="/logout"
							class="btn btn-primary btn-sm mb-3 float-right"><button class="button button1">LOGIN</button> </a> </a>
					</p>
				</c:when>
				<c:otherwise>
					<a href="/login" class="btn btn-primary btn-sm mb-3 float-right">
						<button class="button button1">LOGIN</button> </a> </a>
				</c:otherwise>
			</c:choose>
		</h3>
		<hr>
		<a href="/medium" class="btn btn-primary btn-sm mb-3"> medium.com </a> <!-- <a
			href="/h2-console" class="btn btn-primary btn-sm mb-3 float-right">
			H2 - Console </a> -->
		<hr>
		<h1 style="font-size: 50px"><center>WELCOME TO WEB SCRAWLER</center></h1>
		<form action="reg" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
	</div>
</body>
</html>
