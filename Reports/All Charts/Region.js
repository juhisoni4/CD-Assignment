	 var jsonData13;
	 
		$.getJSON("bubble1.json",function(data){
		 jsonData13 = data;
		 });
		 
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
	 
      function drawChart() {
      
		var data1 = new google.visualization.DataTable();
		//bubble name
			data1.addColumn('string', 'bubblename');
			//x axis
			data1.addColumn('number','year');
			//data1.addColumn('string','month');
			//data1.addColumn('Date',date);
			//y axis
			data1.addColumn('number', 'revenue');
			//variable 
			//series same colour
			data1.addColumn('string','region');
		data1.addColumn('number', 'margin');
		
		
		console.log(jsonData);
		for (var i = 0; i < jsonData13.length; i++){
        data1.addRow(jsonData13[i]); 
		
		} 	
      
       

 var options = {
       title: 'Margin/Country',
	          'width': 1000,
              'height': 500,
      // width: 500,
      // height: 300,
       //legend: 'none',
      // bar: {groupWidth: '95%'},
       vAxis: { 
             title :'revenue',
             gridlines: { count: 10 } 
              },
        hAxis: {
		 viewWindow: {
        
    },
	//ticks :[2005,2010,2015,2020];
               title :'year',
                gridlines: {count: 7}
				
              }
     };

	
        var chart = new google.visualization.BubbleChart(document.getElementById('region_div'));
        chart.draw(data1, options);
      }