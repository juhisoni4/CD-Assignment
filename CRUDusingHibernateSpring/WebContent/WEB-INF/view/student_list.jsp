<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Tracker Application</title>
</head>
<body>
	<h3>Student Information</h3>
	<form:form action="addJsp">
		<input type="submit" value="Add Student" />
	</form:form><br/>

	<table border="1px">
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>UserName</th>
			<th colspan="2">Action</th>
		</tr>

		<tr>
			<c:forEach var="tempStudent" items="${STUDENT_LIST}">
				<c:url var="Delete" value="deleteStudent">
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
				</c:url>
				<c:url var="Update" value="loadStudent">
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
				</c:url>
				<tr>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.studentLoggin.userName}</td>
					<td><a href="${Update}">Update</a> |<a href="${Delete}"
						onclick="if (!(confirm('Are you sure you want to delete this student?')))return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
	</table><br/>
	
	<a href ="logout" >Logout</a>
</body>
</html>