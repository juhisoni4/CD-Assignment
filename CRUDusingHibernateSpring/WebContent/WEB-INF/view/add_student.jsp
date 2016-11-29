<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form:form action="addStudent.do" modelAttribute="student">
	First Name:<input type="text" name="firstName" value="${STUDENT.firstName}"/><br>
	Last Name:<input type="text" name="lastName" value="${STUDENT.lastName}"/><br>
	Email:<input type="text" name="email" value="${STUDENT.email}"/><br>
	<input type="submit" value="submit">
	</form:form>

</body>
</html>