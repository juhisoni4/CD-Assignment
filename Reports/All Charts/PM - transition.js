	  // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {"packages":["corechart", "controls"]});
	 
      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart1);
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
		var jsonData3;
		$.getJSON("data3.json",function(data){
		 jsonData3 = data;
		 });
		
		var data1 = [];		
		
	    function drawChart1() {
			  
		for(var i = 0; i<jsonData3.length; i++){
				data1.push(jsonData3[i]);				
		}	
		
		var data3 = new google.visualization.arrayToDataTable(data1);		
		
		var dashboard = new google.visualization.Dashboard(
            document.getElementById('dashboard_div'));
			
		 var donutRangeSlider = new google.visualization.ControlWrapper({
          'controlType': 'NumberRangeFilter',
          'containerId': 'filter_div',
          'options': {
            'filterColumnLabel': 'Revenue'
          }
        });
		
		var ColumnChart = new google.visualization.ChartWrapper({
          'chartType': 'ColumnChart',
          'containerId': 'chart_div',
          'options': {
			 animation:{
						 startup:true,
						 duration: 1000,
						 easing: 'out'
						},
			'title':'Revenue of Client',			
            'width': 1000,
            'height': 500,
           'legend': 'right'
          }
        });
		
		  dashboard.bind(donutRangeSlider, ColumnChart);
		
		  dashboard.draw(data3);
		  
		 }		
		

   
	  
	    
	 