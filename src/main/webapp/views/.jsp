<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="1" align="center">
             
		<tr>
                
			<th>ID</th>
			<th>NAME</th>
			<th>NUMBER</th>
			<th>EMAIL</th>
			<th colspan="2">ACTION</th>

		</tr>

		<c:forEach var="list" items="${contactList}">

			<tr>

				<td>${list.cid}</td>
				<td>${list.cname}</td>
				<td>${list.cnum}</td>
				<td>${list.email}</td>
				<td><a href="#">delete</a></td>
				<td><a href="#">update</a></td>
			</tr>

		</c:forEach>

	</table>



</body>
</html>