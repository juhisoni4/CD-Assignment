var jsonData1;
	 
		$.getJSON("line2data.json",function(data){
		 jsonData11 = data;
		 console.log(jsonData1);
		 
		 });
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart12);

      function drawChart12() {
      
		var data1 = new google.visualization.DataTable();
		data1.addColumn('string', 'Time');
		data1.addColumn('number','onsite');
		data1.addColumn('number', 'offshore');
		data1.addColumn('number', 'license');
		data1.addColumn('number', 'travel');
		
		console.log(jsonData1);
		for (var i = 0; i < jsonData11.length; i++){
        data1.addRow(jsonData11[i]);
		
	 } 	
         
        var options = {
			
		 'width': 1000,
         'height': 500,
         
          legend: { position: 'bottom' },
		  
		  vAxis:{title:'revenue'},
		 
		 hAxis:{title:'Time'},
		 colors: ['#a52714', '#097138','#225954','#482259']
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data1, options);
      }