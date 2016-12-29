<html>
<head>
<title>My App</title>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	
<script src="resources/js/mainApp.js"></script>
<script src="resources/js/app.js"></script>
<style>

  .bar{
    fill: steelblue;
  }

  .bar:hover{
    fill: brown;
  }

	.axis {
	  font: 10px sans-serif;
	}

	.axis path,
	.axis line {
	  fill: none;
	  stroke: #000;
	  shape-rendering: crispEdges;
	}
	<!-- -->
	.toolTip {
  position: absolute;
  display: none;
  min-width: 80px;
  height: auto;
  background: none repeat scroll 0 0 #ffffff;
  border: 1px solid #6F257F;
  padding: 14px;
  text-align: center; 
}
</style>
</head>
<body ng-app="myApp">

	<div ng-controller="myController">
		<p>{{revenue}}</p>
	</div>

</body>
</html>