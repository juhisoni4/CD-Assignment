	  // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {packages:["corechart", "table"]});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
		var jsonData8;
		$.getJSON("data8.json",function(data){
		 jsonData8 = data;
		 });
	
	function drawChart() {		
	      // Create the data table.
        var data1 = new google.visualization.DataTable();
		data1.addColumn('string', 'Month');
		data1.addColumn('number', 'Revenue');	
		
		console.log(jsonData);
		//for (var i = 0; i < jsonData.length; i++){        
		//data1.addRow([jsonData[i].Month,jsonData[i].Revenue]);		
		//data1.setCell(i,0,jsonData[i].Month);
		//data1.setCell(i,1,jsonData[i].Revenue);
		//} 	
		
		for (var i = 0; i < jsonData8.length; i++){
		data1.addRow(jsonData8[i]);
		var length = jsonData8[i];
		console.log(length);
		for(var j = 0;j < length;j++){
		data1.setCell(i,0,jsonData8[j]);
		data1.setCell(i,1,jsonData8[length-1]);
		}
		}
      
        var options = {'title':'Revenue of  Shivani Singh',
						colors: ['#19929D'],
                       'width':1000,
                       'height':500};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('salesPerson_div'));
        chart.draw(data1, options);
		
		var table = new google.visualization.Table(document.getElementById('table5_div'));		
		var formatter = new google.visualization.BarFormat({width: 120});
		formatter.format(data1, 1);
		table.draw(data1, {allowHtml: true,showRowNumber: true, width: '800', height: '300'});     
	  }