<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #999;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #999;
	color: #444;
	background-color: #F7FDFA;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #999;
	color: #fff;
	background-color: #26ADE4;
}

.tg .tg-0pky {
	border-color: inherit;
	text-align: left;
	vertical-align: top
}
</style>
</head>
<body>

		<a href="categories">Category list</a>
		<a href="articles">Article list</a>
		<a href="authors/list">Author list</a>
		<a href="authors/add">Add new Author</a>
		<a href="categories/add">Add new Category</a>
		<a href="articles/add">Add new Article</a>

<h1 align="center">Artykuły</h1>

<table class="tg">
  <tr>
    <th class="tg-0pky">Tytuł</th>
    <th class="tg-0pky">Autor</th>
    <th class="tg-0pky">Data dodania</th>
    <th class="tg-0pky">Data uaktualinienia</th>
    <th class="tg-0pky">Zawartość</th>
    <th class="tg-0pky">Kategorie</th>
    <th class="tg-0pky">Action</th>
  </tr>
 <c:forEach items="${articles}" var="article">
 	<tr>
 		<td class="tg-0pky"> ${article.getTitle()}</td>
 		<td class="tg-0pky">${article.author.firstName} ${article.author.lastName}</td>
 		<td class="tg-0pky">${article.getCreated()}</td>
 		<td class="tg-0pky">${article.getUpdated()}</td>
 		<td class="tg-0pky">${article.getShortenContent()}</td>
 		<td class="tg-0pky">${article.getAllCategories()}</td>
 		
 		<td class="tg-0pky"><a href="articles/update/${article.getId()}">Edytuj</a> | <a href="articles/delete/${article.getId()}">Usuń</a></td>
 	</tr>
 </c:forEach>
</table>

</body>
</html>