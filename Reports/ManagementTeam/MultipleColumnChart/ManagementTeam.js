	 // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {packages:["bar"]});
	  
	  google.charts.setOnLoadCallback(drawChart);

      // Set a callback to run when the Google Visualization API is loaded.
      
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.		
	  
	  	var jsonData1;
		$.getJSON("data1.json",function(data){
		 jsonData1 = data;
		 console.log(jsonData1);
		 });
		 
		 var data1=[];		 
		
	
	function drawChart() {	

		for(var i = 0; i<jsonData1.length; i++){
			data1.push(jsonData1[i]);
		}
		
		var name = "Anand Shah";
		var data3 = new google.visualization.arrayToDataTable(data1);	
      
        var options = {  chart: {
						title: 'Revenue and cost of '+name,						
						},
                       'width':1000,
                       'height':500,
					    colors: ['#7570b3','#d95f02']};

        // Instantiate and draw our chart, passing in some options.
        var chart1 = new google.charts.Bar(document.getElementById('chart_div'));
        chart1.draw(data3, options);	
		
	  }
	 
 
	   
	 