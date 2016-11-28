<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Common form elements and layouts" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="assets/css/chosen.min.css" />
<link rel="stylesheet" href="assets/css/datepicker.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
<link rel="stylesheet"
	href="assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="assets/css/colorpicker.min.css" />

<!-- text fonts -->
<link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<script src="assets/js/ace-extra.min.js"></script>
<title>StudentInfo</title>
</head>
<body class="no-skin">
	<div id="navbar" class="navbar navbar-default">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="index.html" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> Ace Admin
				</small>
				</a>
			</div>
		</div>
	</div>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs"></div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<form:form action="addStudent" modelAttribute="student" method="post" class="form-horizontal"
				role="form">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1">First Name</label>
					<div class="col-sm-9">
						<input type="text" id="form-field-1" placeholder="Username"
							class="col-xs-10 col-sm-5" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-2"> Last Name </label>

					<div class="col-sm-9">
						<input type="password" id="form-field-2" placeholder="Password"
							class="col-xs-10 col-sm-5" /> <span
							class="help-inline col-xs-12 col-sm-7"> </span>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-2"> Email </label>

					<div class="col-sm-9">
						<input type="password" id="form-field-2" placeholder="Password"
							class="col-xs-10 col-sm-5" /> <span
							class="help-inline col-xs-12 col-sm-7"> </span>
					</div>

				</div>
				<div class="clearfix form-actions">
					<div class="col-md-offset-3 col-md-9">
						<button class="btn btn-info" type="submit">
							<i class="ace-icon fa fa-check bigger-110"></i> Submit
						</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>