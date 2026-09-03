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
<h3>Category Create Form</h3>
<form:form action="${pageContext.request.contextPath}/category/create" method="post" modelAttribute="catObj">

<form:label path="name">Name</form:label>
<form:input path="name"/> 
<form:errors path="name"></form:errors>
<br>

<input type="submit" value="create">

</form:form>
</body>
</html>