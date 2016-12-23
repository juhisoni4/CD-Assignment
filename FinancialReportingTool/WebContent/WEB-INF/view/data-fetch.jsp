<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	var app = angular.module('myApp', []);
	app.controller('myData', function($scope) {
		$scope.data = [ {
			model : "Anand Shah", name : "projectManager-Anand Shah"
		}, {
			model : "Jogen G", name : "projectManager-Jogen G"
		}, {
			model : "Juhi Soni", name : "resourceName-Juhi Soni"
		}, {
			model : "Ashish T", name : "salesHead-Ashish T"
		} ];
		
		$scope.financeData = [ {
			model : "Revenue"
		}, {
			model : "Cost"
		}, {
			model : "Margin"
		} ];
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="fetch">
		<div ng-app="myApp" ng-controller="myData">
			<select ng-model="selectedData" name="data">
				<option ng-repeat="x in data" value="{{x.name}}">{{x.model}}</option>
			</select>
			<select ng-model="selectedFinanceData" name="finance">
				<option ng-repeat="x in financeData" value="{{x.model}}">{{x.model}}</option>
			</select>
			<!-- <select name="data">
			<option value="projectManager-Anand Shah">Anand Shah</option>
			<option value="resourceName-Juhi Soni">Juhi Soni</option>
			<option value="salesHead-Ashish T">Ashish T</option>
		</select> 
		<select name="finance">
			<option value="Revenue">Revenue</option>
			<option value="Cost">Cost</option>
			<option value="Margin">Margin</option>
		</select> -->
			<input type="submit" value="submit">
			<%=request.getAttribute("financeData")%>
			</div>
	</form>
	</div>

</body>
</html>