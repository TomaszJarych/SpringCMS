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
<title>Article form</title>
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

	<h1 align="center">Article:</h1>

	<form:form method="post" modelAttribute="article" action="add">

	<form:errors path="" cssStyle="errors" element="div" />
		<h2>
			Title:
			<form:input path="title" />
			<form:errors path="title" cssClass="errors" />
		</h2>
			<h2>Is draft? <form:checkbox	path="draft"/>
			<form:errors path="draft" cssClass="errors" /></h2>
		<div>
			<h2>Author:</h2>
			<form:select path="author">
				<form:options items="${authors}" itemValue="id" itemLabel="fullName" />
			</form:select>
		</div>
		<div>
			<h2>Category:</h2>
			<form:select path="categories" multiple="true">
				<form:options items="${categories}" itemValue="id" itemLabel="name" />
			</form:select>
				<form:errors path="categories" cssClass="errors" />
		</div>
		<h2 align="center">
			Content
			<form:textarea path="content" rows="20" cols="120" />
			<form:errors path="content" cssClass="errors" />
		</h2>

		<form:hidden path="id" />
		<form:hidden path="created" />
		<form:hidden path="updated" />
		<input type="submit" value="Send">

	</form:form>

</body>
</html>