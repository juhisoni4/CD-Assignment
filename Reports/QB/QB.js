	  // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {packages:["geomap", "table"]});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawRegionsMap);
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
		var jsonData;
		$.getJSON("data1.json",function(data){
		 jsonData = data;
		 });
	
		var data=[];
		
	function drawRegionsMap() {		     
		
		
		//for (var i = 0; i < jsonData.length; i++){        
		//data1.addRow([jsonData[i].Month,jsonData[i].Revenue]);		
		//data1.setCell(i,0,jsonData[i].Month);
		//data1.setCell(i,1,jsonData[i].Revenue);
		//} 	
		
		for (var i = 0; i < jsonData.length; i++){
			data.push(jsonData[i]);
		}
      
		var data1 = new google.visualization.arrayToDataTable(data);
		var options = { 'title':'Revenue',
                       'width':1000,
                       'height':500,        
          colorAxis: {colors: ['#FFA733', '#10AB52', '#F54F0F']},          
        };
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
        chart.draw(data1, options);		
	
		//table.draw(data1, {allowHtml: true,showRowNumber: true, width: '800', height: '300'});     
	  }