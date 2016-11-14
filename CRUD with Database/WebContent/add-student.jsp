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
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<br>
		<h1>Student Registration form</h1>
		<br>
		<h4>Fill in the form below</h4>

		<form action="StudentController" method="post">
			<div class="form-group">
				<input type="hidden" name="command" value="ADD"><br>
				<div class="col-sm-7">
					First Name:<input type="text" name="firstName" class="form-control"
						value="${param.firstName}">
				</div>
				<div class="col-sm-7">
					Last Name:<input type="text" name="lastName" class="form-control"
						value="${param.lastName}">
				</div>
				<div class="col-sm-7">
					Email:<input type="text" name="email" class="form-control"
						value="${param.email}">
					<div class="error">${errors.email}</div>
				</div>
				<div class="col-sm-7">
					UserName:<input type="text" name="userName" class="form-control"
						value="${param.userName}">
					<div class="error">${errors.userName}</div>
				</div>
				<div class="col-sm-7">
					Password:<input type="password" name="password"
						class="form-control"><br>
				</div>
				<div class="col-sm-7">
					<input type="submit" class="btn btn-primary" value="Submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>




