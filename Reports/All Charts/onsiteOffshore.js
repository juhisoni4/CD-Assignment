var jsonData12;
	 
		$.getJSON("line.json",function(data){
		 jsonData12 = data;
		 //console.log(jsonData);
		 
		 });
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
      
		var data1 = new google.visualization.DataTable();
		data1.addColumn('number', 'year');
		data1.addColumn('number','onsite');
		data1.addColumn('number', 'offshore');
		//data1.addColumn('number', 'number');
		
		
		console.log(jsonData);
		for (var i = 0; i < jsonData12.length; i++){
        data1.addRow(jsonData12[i]);
		
	 } 	
         
        var options = {
          title: 'Onsite/Offshore',
		   'width': 1000,
          'height': 500,
          curveType: 'function',
          legend: { position: 'bottom' },
		  
		  vAxis:{title:'revenue'},
		 
		 hAxis:{title:'year'}
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve1_chart'));

        chart.draw(data1, options);
      }