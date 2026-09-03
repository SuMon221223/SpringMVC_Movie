<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Admin Movie List</h3>

	<table>

		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Duration</th>
			<!-- <th>Description</th>
			<th>Release Year</th>
			
			<th>Category ID</th> -->
		</tr>


		<c:forEach items="${movieList}" var="movie" varStatus="index">
			<tr>
			<td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.duration}</td>
            <%-- <td>${movie.description}</td>
            <td>${movie.releaseYear}</td>
            
            <td>${movie.categoryId}</td> --%>
				<td><a
					href="${pageContext.request.contextPath}/admin/movie_getbyid/${movie.id}">edit</a>
					<a
					href="${pageContext.request.contextPath}/admin/movie_remove/${movie.id}">remove</a>
				</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>