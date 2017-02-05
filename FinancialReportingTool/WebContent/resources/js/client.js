(function() {
	app.controller("myController", myController);	
	myController.$inject = [ "$scope", "$http"];
	
	function myController($scope, $http) {
		
		$scope.chart = function(){
			$http.get("http://localhost:8080/FinancialReportingTool/client/list1"
	           
			) .success(function (data) {
				
				var data2 = [];
				for(var i in data){					
					 data2.push([data[i].clientName, data[i].cost, data[i].actualProjectMargin, data[i].actualProjectMarginPercentage ,data[i].revenue]);
				}
				
				console.log(data2);				
				
				google.charts.load("visualization", "1", {packages:["corechart", "table"]});
				 
				google.charts.setOnLoadCallback(drawChart);	
				
				
				function drawChart() {						
				
				var data1 = new google.visualization.DataTable();
				data1.addColumn('string', 'Client');				
				data1.addColumn('number', 'Cost');
				data1.addColumn('number', 'Margin');
				data1.addColumn('number', 'MarginPercentage');
				data1.addColumn('number', 'Revenue');
				data1.addRows(data2);					
				
					
				/*var options = {
						vAxis: {title: 'Cups'},
						hAxis: {title: 'Month'},	 
						seriesType: 'bars',
					    series: {3: {type: 'line', pointSize: 3}}
						};
						*/
				
				var options = {
				          colorAxis: {colors: ['yellow', 'red']},
				          bubble: {
				              textStyle: {
				                fontSize: 12,
				                fontName: 'Arial',
				                color: '#900C3F',
				                bold: true,
				                auraColor: 'none'
				              }
				            }
				        };
					 
				var chart = new google.visualization.BubbleChart(document.getElementById('chart_div'));
				chart.draw(data1, options);						
				
			}
				
			});
	            
		}();
	};
})();
