	  // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {packages:["corechart", 'controls']});
	 
      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart1);
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
		var jsonData1;
		$.getJSON("data1.json",function(data){
		 jsonData1 = data;
		 });
		
		var data1 = [];
		
		var jsonData2;
		$.getJSON("data.json",function(data){
		 jsonData2 = data;
		 });
		 
		 var data2 = [];	 	  
       
	     var current = 0;
		
		
	    function drawChart1() {
			  
		for(var i = 0; i<jsonData1.length; i++){
				data1.push(jsonData1[i]);				
		}	
		
		var data3 = new google.visualization.arrayToDataTable(data1);
		
		//var chart = new google.visualization.ComboChart(document.getElementById('visualization'));
		
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
		 
		 function drawChart2() {
			  
		for(var i = 0; i<jsonData2.length; i++){
				data2.push(jsonData2[i]);				
		}
		
		var data4 = new google.visualization.arrayToDataTable(data1);
		
		var chart = new google.visualization.ComboChart(document.getElementById('visualization'));
		
		 var options = {'title':'Revenue of Anand Shah',
						 animation:{
						 startup:true,
						 duration: 1000,
						 easing: 'out'
						},
                       'width':1000,
                       'height':500};	
					  
		   chart.draw(data4, options);
		  
		 }	

   
	  
	    
	 