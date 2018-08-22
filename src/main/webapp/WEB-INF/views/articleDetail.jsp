<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.getTitle()}</title>
</head>
<body>
<h1>Tytuł artykułu</h1>
<h2>${article.getTitle()}</h2>
<h1>Autor</h1>
<h2>${article.getAuthor().getFirstName()} ${article.getAuthor().getLastName()}</h2>
<h1>Stworzono</h1>
<h2>${article.getCreated()}</h2>
<h1>Uaktualniono</h1>
<h2>${article.getUpdated()}</h2>
<br></br>
<h1>Zawartość</h1>
<h4>${article.getContent()}</h4>
<br></br>
<h3><a href="http://localhost:8080/SpringCMS/articles">Powrót do strony głównej</a></h3>


</body>
</html>