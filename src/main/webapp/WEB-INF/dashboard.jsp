<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/4f7f009016.js"
	crossorigin="anonymous"></script>
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container my-auto p-2 ">
		<div class="row">
			<div class="col">
				<h1>Questions Dashboard</h1>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table">
					<thead>
						<tr>
							<th>Question</th>
							<th>Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questions}"	 var="q">
							<tr>
								<td> <a href="/questions/${q.id}"> ${q.questionText} </a></td>
								<td>${q.tagsString }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/questions/new">New Question <i
					class="fa-solid fa-comment-dots"></i></a>
			</div>
		</div>
	</div>
</body>
</html>