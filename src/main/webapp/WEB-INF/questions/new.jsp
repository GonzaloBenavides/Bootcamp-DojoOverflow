<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/boostrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/4f7f009016.js"
	crossorigin="anonymous"></script>
<title>New Question</title>
</head>
<body>
	<div class="container p-2">
		<div class="row">
			<h1>What is your question?</h1>
		</div>
		<form:form modelAttribute="question" action="/questions/new"
			method="POST">
			<div class="row p-1">
				<div class="col-md-1">
					<form:label path="questionText">Question:</form:label>
				</div>
				<div class="col">
					<form:textarea class="form-control" path="questionText"
						style="width:50%;" />
				</div>
			</div>
			<div class="row p-1">
				<div class="col-md-1">
					<form:label path="tagsTransient">Tags:</form:label>
				</div>
				<div class="col">
					<form:input class="form-control" style="width:40%;" type="text"
						path="tagsTransient" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-auto">
					<a class="btn shadow-flow btn-danger" href="/">Cancel </a>
				</div>
				
				<div class="col">
					<form:errors path="questionText"></form:errors>
					<form:errors path="tagsTransient"></form:errors>
				</div>
				<div class="col">
					<form:button class="btn btn-primary shadow-flow">Submit</form:button>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>