<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Movie List</h3>
<form:form modelAttribute="usermovieObj" action="${pageContext.request.contextPath}/choose" method="post">

<form:hidden path="userId"/>

<c:forEach items="${movieList}" var="movie">
    <p>
    <form:checkbox path="movieIds" value="${movie.id}"/> ${movie.title}
    </p>
</c:forEach>

<%-- <form:checkboxes items="${movieList }" path="movieIds"/><br> --%>
<input type="submit" value="choose">

</form:form>
</body>
</html>