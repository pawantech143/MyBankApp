<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">

   function deleteConfirm(){

	   return confirm("Are your sure,Want to delete?");
	   }
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<body>

	<div class="container">

		<div class="card-header ">

			<h1>Contact List</h1>
			
			

		</div>

		<div class="card-body">

			<a href="/" class="btn btn-success">+Add Contact</a>
			<table class="table table-hover">

				<tr>

					<th>Name</th>
					<th>Number</th>
					<th>Email</th>
					<th>Action</th>

				</tr>

				<c:forEach items="${contactList}" var="contact">
					<tr>
						<td>${contact.cname}</td>
						<td>${contact.cnum}</td>
						<td>${contact.email}</td>
						<td><a href="edditContact?cid=${contact.cid}"
							class="btn btn-success">edit</a> <a
							href="deleteContact?cid=${contact.cid}" onclick="return deleteConfirm()" class="btn btn-danger">delete</a></td>
					</tr>
				</c:forEach>

			</table>


		</div>

                   <div class="card-footer">
                   
                    ${deleteSuccess} 
                   
                   </div>

	</div>
	

</body>
</html>