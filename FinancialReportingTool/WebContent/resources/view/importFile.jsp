<html>
<head>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.1.min.js"></script>
	<script src = "/FinancialReportingTool/resources/js/mainApp.js"></script>
	<script src = "/FinancialReportingTool/resources/js/import-directive.js"></script>
	<script src = "/FinancialReportingTool/resources/js/importFile.js"></script>	
	</head>	
	<body ng-app = "app">	
	<div ng-controller = "myController">
    <input type="file" file="file" required />
    <button ng-click="import()">upload me</button>	
	<button ng-click="exportFile()">download me</button>
	</div>
	 <div id="donut-example"></div>
	</body>

</body>
</html> 

