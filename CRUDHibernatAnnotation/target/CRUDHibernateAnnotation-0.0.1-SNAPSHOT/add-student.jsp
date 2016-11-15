<html>

<body>
	<div>
		<h2>Student Registration Form</h2>
	</div>

	<div>
		<form action="StudentControllerServlet" method="post">
			<input type="hidden" name="command" value="ADD" /> First Name:<input
				type="text" name="first_name" /> <br />
			<br /> Last Name:<input type="text" name="last_name" /> <br />
			<br /> Email:<input type="text" name="email" /> <br />
			<br /> <input type="submit" name="submit" /> <br />
			<br /> <a href="StudentControllerServlet">Back to the main page</a>


		</form>
	</div>
</body>
</html>