<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Tracker App</title>
</head>

<body>
	<div>
		<h2>Student Information</h2>
	</div>

	<div>
		<input type="button" value="Add Student"
			onclick="window.location.href='add-student.jsp'; return false;" />
			<br/><br/>
			
		<table border="1">
			<tr>
				<th><b>Id</b></th>
				<th><b>First Name</b></th>
				<th><b>Last Name</b></th>
				<th><b>email</b></th>
				<th><b>Action</b>
			</tr>

			<c:forEach var="tempStudent" items="${STUDENT_LIST}">
			
			<!-- Set up the link for each student -->
				<c:url var="tempLink" value="StudentControllerServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
				</c:url>
				
				<!-- set up a link for delete -->
				<c:url var="deleteLink" value="StudentControllerServlet">
				<c:param name="command" value="DELETE"/>
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
				</c:url>
				<tr>
					<td>${tempStudent.id}</td>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
					<td><a href="${tempLink}">Update</a>
					| 
						<a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delet this student?')))return false">Delete</a>
						</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
