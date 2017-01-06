
      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

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
		for (var i = 0; i < jsonData.length; i++){
        data1.addRow(jsonData[i]); } 	
      
        var options = {'title':'Revenue of Anand Shah',
                       'width':1000,
                       'height':500};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data1, options);
      }