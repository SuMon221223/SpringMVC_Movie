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
<h3>Admin Category List</h3>

<table>

<tr>
<th>No</th>
<th>Name</th>
<th>Action</th>
</tr>


<c:forEach items="${categoryList}" var="category" varStatus="index">
<tr>
<td>${index.count}</td>
<td>${category.name}</td>
<td>
<a href="${pageContext.request.contextPath}/admin/category_getbyid/${category.id}">edit</a>
<a href="${pageContext.request.contextPath}/admin/category_remove/${category.id}">remove</a>
</td>
</tr>
</c:forEach>

</table>


</body>
</html>