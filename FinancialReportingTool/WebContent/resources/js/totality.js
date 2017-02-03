(function() {
	app.controller("myController", myController);	
	myController.$inject = [ "$scope", "$http"];
	
	function myController($scope, $http) {
		
		$scope.chart = function(){
			$http.get("http://localhost:8080/FinancialReportingTool/financeData/list2"
	           
			) .success(function (data) {
				console.log(data);
				var data2 = [];
				for(var i in data){					
					 data2.push([data[i].month, data[i].revenue, data[i].cost, data[i].actualProjectMargin,data[i].actualProjectMarginPercentage]);
				}
				
				console.log(data2);				
				
				google.charts.load("visualization", "1", {packages:["corechart", "table"]});
				 
				google.charts.setOnLoadCallback(drawChart);	

	
				function drawChart() {		
	      // Create the data table.
					var data1 = new google.visualization.DataTable();
					data1.addColumn('string', 'Month');
					data1.addColumn('number', 'Revenue');
					data1.addColumn('number', 'Cost');
					data1.addColumn('number', 'Margin');
					data1.addColumn('number', 'MarginPercentage');
					data1.addRows(data2);					
						
		
		     
					var options = {							
						curveType: 'function',
						pointSize: 10,
						'width':1000,
						'height':500,
						dataOpacity: 0.3
						/*vAxis: {title: 'Cups'},
						hAxis: {title: 'Month'},	 
						seriesType: 'bars',
					    series: {3: {type: 'line', pointSize: 3}}*/
					};		
		
      
					var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
					chart.draw(data1, options);
	
				}
				
			});
	      
		};
	};
})();