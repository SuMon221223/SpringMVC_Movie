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
<h3>User Login Form</h3>
<p>${error }</p>
<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="loginObj">

<form:label path="name">Name</form:label>
<form:input path="name"/> 
<form:errors path="name"></form:errors>
<br>

<input type="submit" value="create">

</form:form>

<a href="${pageContext.request.contextPath}/user/form">Create an account</a>

</body>
</html>