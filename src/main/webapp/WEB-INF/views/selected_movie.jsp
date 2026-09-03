<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Movie Rented List</h3>
<p>Username : ${movieList[0].username}</p>
<ol>

<c:forEach items="${movieList }" var="obj">

<li>${obj.movieTitle }</li>

</c:forEach>

</ol>

</body>
</html>