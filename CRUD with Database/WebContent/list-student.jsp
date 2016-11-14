
<%@page import="com.crud.with.database.StudentController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Student Registration</title>
<style type="text/css">
h1 {
	text-align: center;
}
</style>
</head>
<body>

	<div class="container">
		<br>
		<h1>Student Information</h1>
		<br>

		<div>
			<%			
			String userName = StudentController.getCookie(request, response);
			%>

					
			 <h3>
				Hi <%=userName%>, Login successful.
			</h3> 
			
		</div>
		<br>

		<form action="add-student.jsp">
			<input type="submit" class="btn btn-primary" value="Add Student"><br>
			<br>
		</form>

		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th colspan="2">Action</th>
			</tr>

			<tr>
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
					<c:url var="Delete" value="StudentController">
						<c:param name="StudentId" value="${tempStudent.id}" />
						<c:param name="command" value="DELETE" />
					</c:url>
					<c:url var="Update" value="StudentController">
						<c:param name="StudentId" value="${tempStudent.id}" />
						<c:param name="command" value="LOAD" />
					</c:url>
					<tr>
						<td>${tempStudent.id}</td>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.email}</td>
						<td><a href="${Update}">Update</a> |<a href="${Delete }"
							onclick="if (!(confirm('Are you sure you want to delete this student?')))return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
		</table>
		<br>


		<form action="LogoutServlet" method="post">
			<input type="submit" class="btn btn-primary" value="Logout">
		</form>
	</div>
</body>
</html>