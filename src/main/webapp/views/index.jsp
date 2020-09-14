<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>


	<form:form action="saveContact" method="post" modelAttribute="contact">

		<font color="green"> ${successMsg} </font>

		<font color="red"> ${errorMsg} </font>
		
		<font color="blue"> ${updated} </font>

		<table bgcolor="cyan">

			<tr>
				<td>Name:</td>
				<td><form:input path="cname" /></td>
				<form:hidden path="cid" value="" />
			</tr>


			<tr>
				<td>Number:</td>
				<td><form:input path="cnum" /></td>
			</tr>


			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>

				<td><input type="submit" value="submit"></td>
			</tr>

		</table>
	</form:form>
	<a href="viewContacts">View Contact List</a>
</body>
</html>