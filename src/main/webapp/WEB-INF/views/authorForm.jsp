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
<title>Author form</title>
</head>
<body>

	<h1 align="center">Author:</h1>

	<form:form method="post" modelAttribute="author" action="add">

		<h2>
			First name:
			<form:input path="firstName" />
			<form:errors path="firstName" cssClass="errors" />
		</h2>
		<h2>
			Last name:
			<form:input path="lastName" />
			<form:errors path="lastName" cssClass="errors" />
		</h2>

		<form:hidden path="id" />
		<input type="submit" value="Send">

	</form:form>

</body>
</html>