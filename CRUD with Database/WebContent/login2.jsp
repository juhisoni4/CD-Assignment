<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<br>
		<h3 style=color:red>Enter UserName or Password</h3>
		<br>
		<form action="StudentController" method="post">
			<div class="form-group col-sm-7">
				UserName:<input type="text" name="username" class="form-control"><br>
				Password:<input type="password" name="password" class="form-control"><br>
				<input type="submit" class="btn btn-primary" value="Submit">
			</div>
		</form>
	</div>
</body>
</html>