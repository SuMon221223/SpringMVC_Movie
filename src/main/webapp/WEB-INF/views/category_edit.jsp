<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Category Update Form</h3>
<p>${error }</p>
<form:form action="${pageContext.request.contextPath}/admin/movie_update" method="post" modelAttribute="catObj">

<form:hidden path="id"/>

<form:label path="name">Name</form:label>
<form:input path="name"/> 
<br>

<input type="submit" value="update">

</form:form>
</body>
</html>