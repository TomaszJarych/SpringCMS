<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Article:</h1>

	<form:form method="post" modelAttribute="article"
		action="add">

		<h2>Title: <form:input path="title" /></h2>
		<div>
			<h2>Author: </h2>
			<form:select path="author">
				<form:options items="${authors}" itemValue="id" itemLabel="fullName" />
			</form:select>
		</div>
		<div>
			<h2>Category: </h2>
			<form:select path="categories" multiple="true">
				<form:options items="${categories}"  itemValue="id" itemLabel="name" />
			</form:select>
		</div>
		<h2 align="center" >Content <form:textarea path="content" rows="20" cols="120" /></h2>
		
		<form:hidden path="id" />
		<form:hidden path="created" />
		<form:hidden path="updated" />
		<input type="submit" value="Send">

	</form:form>

</body>
</html>