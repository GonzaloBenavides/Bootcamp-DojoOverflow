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
<link rel="stylesheet" href="/css.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/4f7f009016.js"
	crossorigin="anonymous"></script>
<title>Check Question</title>
</head>
<body>
	<div class="container p-2">
		<div class="row-md-auto">
			<a class="btn btn-primary" href="/">Back <i
					class="fa-solid fa-house"></i></a>
		</div>
		<div class="row">
			<h1>${question.questionText}</h1>
		</div>
		<div class="row">
			<div class="col align-middle">
				<h2 style="display: inline-block">Tags:</h2>

				<c:forEach items="${question.tags}" var="t">
					<button class="btn btn-secondary rounded-0 px-1 py-0 mb-2 ">${t.tag}</button>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-striped table-hover border ">
					<thead>
						<tr>
							<th>Answers</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach items="${question.answers}" var="a">
							<tr>
								<td>${a.answerText}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h2>Add your answer:</h2>
				<form:form action="/questions/${question.id}" method="POST"
					modelAttribute="answer">
					<div class="row">
						<div class="col-md-auto">
							<form:label class="form-label" path="answerText"> Answer! </form:label>
						</div>
						<div class="col">
							<form:textarea class="form-control" path="answerText" />
						</div>
					</div>
					<div class="row mt-2">
						<div class="col">
							<form:errors path="answerText"></form:errors>
							<form:button style="float:right" class="btn btn-secondary shadow-flow">
							Answer it! <i class="fa-solid fa-message"></i>
							</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>