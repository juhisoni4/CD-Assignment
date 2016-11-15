<html>

<body>
	<div>
		<h2>Student Registration Form</h2>
	</div>

	<div>
		<form action="StudentControllerServlet" method="post">
			<input type="hidden" name="command" value="UPDATE" /> <input
				type="hidden" name="studentId" value="${THE_STUDENT.id }" /> First
			Name:<input type="text" name="first_name"
				value="${THE_STUDENT.firstName}" /> <br />
			<br /> Last Name:<input type="text" name="last_name"
				value="${THE_STUDENT.lastName}" /> <br />
			<br /> Email:<input type="text" name="email"
				value="${THE_STUDENT.email}" /> <br />
			<br /> <input type="submit" name="submit" /> <br />
			<br /> <a href="StudentControllerServlet">Back to the main page</a>


		</form>
	</div>
</body>
</html>