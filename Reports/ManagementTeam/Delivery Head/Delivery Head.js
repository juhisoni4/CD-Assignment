	  // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {packages:["corechart", "table"]});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
		var jsonData;
		$.getJSON("data1.json",function(data){
		 jsonData = data;
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
		
		for (var i = 0; i < jsonData.length; i++){
		data1.addRow(jsonData[i]);
		var length = jsonData[i];
		console.log(length);
		for(var j = 0;j < length;j++){
		data1.setCell(i,0,jsonData[j]);
		data1.setCell(i,1,jsonData[length-1]);
		}
		}
      
        var options = {'title':'Revenue of Anand Shah',
						colors: ['#E61635'],
                       'width':1000,
                       'height':500};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data1, options);
		
		var table = new google.visualization.Table(document.getElementById('table_div'));		
		var formatter = new google.visualization.ArrowFormat({width: 120});
		formatter.format(data1, 1);
		table.draw(data1, {allowHtml: true,showRowNumber: true, width: '800', height: '300'});     
	  }