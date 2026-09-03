<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>User Register Form</h3>
<form:form action="${pageContext.request.contextPath}/user/create" method="post" modelAttribute="userObj">

<form:label path="name">Name</form:label>
<form:input path="name"/> 
<br>

<form:label path="gender">Gender</form:label>
<form:radiobutton path="gender" value="Male"/>Male
<form:radiobutton path="gender" value="Female"/>Female <br>

<form:label path="salutationType">Salutation</form:label>
<form:select path="salutationType">
<form:option value="">None</form:option>

<%-- <c:forEach items="${list }" var="typeObj">
<form:option value="${ typeObj.type}"></form:option>
</c:forEach> --%>
<form:options items="${list}"/>

</form:select>

<form:label path="address">Address</form:label>
<form:textarea path="address"/> <br>

<input type="submit" value="create">

</form:form>

<span>${error}</span>
</body>
</html>