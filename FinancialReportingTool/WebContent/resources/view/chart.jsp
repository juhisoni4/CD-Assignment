<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	 <script src = "/FinancialReportingTool/resources/js/mainApp.js"></script>
	 <script type="text/javascript" src="/FinancialReportingTool/resources/js/client.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body ng-app = "app">	
	<div ng-controller = "myController"> 
	<input type="button" ng-click="chart()"/> 
  	<div id="chart_div" style="width: 900px; height: 500px;" ></div>
  	<div id='table_div' align="center"></div>	
  	</div>	
</body>


</html>