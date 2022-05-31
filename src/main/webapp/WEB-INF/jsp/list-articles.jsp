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
		<a href="/" class="btn btn-primary btn-sm mr-2 mb-3 float-right">
			Back </a>
		<form action="/medium/search" class="form-inline">
			<input type="search" name="tag" value="${Tag}" placeholder="Tag"
				class="form-control-sm mr-2 mb-3" />
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
		</form>

		<c:forEach items="${Articles}" var="article">
			<button type="button" class="collapsible" style="text-align: center;">
				<c:out value="${article.title}" />
			</button>
			<div class="content">
				<table class="table table-bordered table-striped"
					style="text-align: center;">
					<thead class="thead-dark">
						<tr>
							<th>Creator</th>
							<th>Blog</th>
							<th>Details</th>
							<th>View</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${article.creator}" /></td>
							<td><c:out value="${article.blog}" /></td>
							<td><c:out value="${article.details}" /></td>
							<td><a href="/medium/view?creator=${article.creator}&title=${article.title}"
								class="btn btn-primary btn-sm mb-3" target="_blank"> View </a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<br>
		</c:forEach>
	</div>
</body>
<style>
.collapsible {
	background-color: #777;
	color: white;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 15px;
}

.active, .collapsible:hover {
	background-color: #555;
}

.collapsible:after {
	content: '\002B';
	color: white;
	font-weight: bold;
	float: right;
	margin-left: 5px;
}

.active:after {
	content: "\2212";
}

.content {
	padding: 0 18px;
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.2s ease-out;
	background-color: #f1f1f1;
}
</style>

<script>
	var coll = document.getElementsByClassName("collapsible");
	var i;

	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var content = this.nextElementSibling;
			if (content.style.maxHeight) {
				content.style.maxHeight = null;
			} else {
				content.style.maxHeight = content.scrollHeight + "px";
			}
		});
	}
</script>
</html>

