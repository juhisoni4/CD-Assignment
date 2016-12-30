(function() {
	app.controller("myController", myController);	
	myController.$inject = [ "$scope", "$http"];
	
	function myController($scope, $http) {
		console.log("In controller");
		$http.get("http://localhost:8080/FinancialReportingTool/financeData/list").success(
				function(data) {
					$scope.revenue = data;
					var data1 = data;
					var data = [];	
					
					for(var prop in data1){						
						var myData = new Object();
						myData.Month = prop,
						myData.Revenue = data1[prop];
						console.log(prop+":"+data1[prop]);
						data.push(myData);
						console.log(myData);
					}		
				
					console.log(data);
					var margin = {top: 20, right: 20, bottom: 70, left: 40},
				    width = 600 - margin.left - margin.right,
				    height = 350 - margin.top - margin.bottom;

				//tooltip

				var tooltip = d3.select("body").append("div").attr("class", "toolTip");

				// set the ranges
				var x = d3.scale.ordinal().rangeRoundBands([0, width], .04);//interval over width ,width expects value between 0 and 1 ,rangebands is similar method
				//([0,elementwidth},barpad,barouterpad)
				var y = d3.scale.linear().range([height, 0]);

				// define the axis
				var xAxis = d3.svg.axis()
				    .scale(x)
				    .orient("bottom");


				var yAxis = d3.svg.axis()
				    .scale(y)
				    .orient("left")
				    .ticks(10);


				// add the SVG element
				var svg = d3.select("body").append("svg")
				    .attr("width", width + margin.left + margin.right)
				    .attr("height", height + margin.top + margin.bottom)
				  .append("g")
				    .attr("transform", 
				          "translate(" + margin.left + "," + margin.top + ")");
			
				/*d3.json(data, function(error, data) {
					 
				    data.forEach(function(d) {
				       d.Month = d.Month;
				       d.Revenue = +d.Revenue;
				    });
				});*/
				
				
				  // scale the range of the data
				  x.domain(data.map(function(d) { return d.Month; }));
				  y.domain([0, d3.max(data, function(d) { return d.Revenue; })]);

				  // add axis
				  svg.append("g")
				      .attr("class", "x axis")
				      .attr("transform", "translate(0," + height + ")")
				      .call(xAxis)
				    .selectAll("text")
				      .style("text-anchor", "end")
				      .attr("dx", "-.8em")
				      .attr("dy", "-.55em")
				      .attr("transform", "rotate(-90)" );

				  svg.append("g")
				      .attr("class", "y axis")
				      .call(yAxis)
				    .append("text")
				      .attr("transform", "rotate(-90)")
				      .attr("y", 5)
				      .attr("dy", ".71em")
				      .style("text-anchor", "end")
				      .text("Revenue $");


				  // Add bar chart
				  svg.selectAll("bar")
				      .data(data)
				    .enter().append("rect")
				      .attr("class", "bar")
				      .attr("x", function(d) { return x(d.Month); })
				     .attr("width", x.rangeBand())
				     // .attr("width", Math.min(x.rangeBand()-2, 30))
				      .attr("y", function(d) { return y(d.Revenue); })
				      .attr("height", function(d) { return height - y(d.Revenue); })
				        
					  .on("mouseover", function(d){//mousemove
								    tooltip
				               .style("left", d3.event.pageX - 20 + "px")
				              .style("top", d3.event.pageY - 10 + "px")
				              .style("display", "inline-block")
				              .html((d.Month) + "<br>" + "$" + (d.Revenue));
				        })
				    		.on("mouseout", function(d){ tooltip.style("display", "none");});
					  
					  //third variable 
					   

				  svg.append("rect")
				      .attr("x", width - 150)
				      .attr("width", 19)
				      .attr("height", 19)
				      .attr("fill", "steelblue");
					  
					  svg.append("text")
				      .attr("x", width - 120)
				      .attr("y", 10)
				      .attr("dy", "0.5em")
				      .text("Project Manager 1");
					
				}).error(function(error) {
			console.log("Error");
		});		
	};
})();