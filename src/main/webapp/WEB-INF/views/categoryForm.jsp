<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.errors {
	color: red;
	border-color: red;
	border-width: medium;
	font: bold;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Menu</h1>
		<a href="http://localhost:8080/SpringCMS/day4/category">Category list</a>
		<a href="http://localhost:8080/SpringCMS/day4/category/add">Add new Category</a>
		<a href="http://localhost:8080/SpringCMS/day4/author/list">Author list</a>
		<a href="http://localhost:8080/SpringCMS/day4/author/add">Add new Author</a>
		<a href="http://localhost:8080/SpringCMS/day4/article/list">Article list</a>
		<a href="http://localhost:8080/SpringCMS/day4/article/add">Add new Article</a>
</h3>

	<h1 align="center">Category:</h1>

	<form:form method="post" modelAttribute="category"
		action="add">

		<h2>
			Name:
			<form:input path="name" />
			<form:errors path="name" cssClass="errors" />
		</h2>
		<h2>
			Description:
			<form:input path="description" />
		</h2>

		<form:hidden path="id" />
		<input type="submit" value="Send">

	</form:form>

</body>
</html>