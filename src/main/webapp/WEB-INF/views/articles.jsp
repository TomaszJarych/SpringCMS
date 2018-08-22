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
<h1 align="center">Artykuły</h1>

<table class="tg">
  <tr>
    <th class="tg-0pky">Tytuł</th>
    <th class="tg-0pky">Data dodania</th>
    <th class="tg-0pky">Zawartość</th>
    <th class="tg-0pky">Action</th>
  </tr>
 <c:forEach items="${list}" var="article">
 	<tr>
 		<td class="tg-0pky"> ${article.getTitle()}</td>
 		<td class="tg-0pky">${article.getCreated()}</td>
 		<td class="tg-0pky">${article.getContent()}</td>
 		<td class="tg-0pky"><a href="http://localhost:8080/SpringCMS/articlesById/${article.getId()}">Szczegóły</a> | <a href="http://localhost:8080/SpringCMS/deleteArticle/${article.getId()}">Usuń</a></td>
 	</tr>
 </c:forEach>
</table>


<h1 align="center">Kategorie</h1>

<table class="tg">
  <tr>
    <th class="tg-0pky">Nazwa</th>
    <th class="tg-0pky">opis</th>
    <th class="tg-0pky">Action</th>
  </tr>
 <c:forEach items="${categoires}" var="category">
 	<tr>
 		<td class="tg-0pky"> ${category.getName()}</td>
 		<td class="tg-0pky">${category.getDescription()}</td>
 		<td class="tg-0pky"><a href="http://localhost:8080/SpringCMS/articlesByCategory/${category.getId()}">Artykuły z kategorii ${category.getName()}</a></td>
 	</tr>
 </c:forEach>
</table>

<h3><a href="http://localhost:8080/SpringCMS/articles">Powrót do strony głównej</a></h3>

</body>
</html>