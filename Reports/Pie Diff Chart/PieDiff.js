	 // Load the Visualization API and the corechart package.
      google.charts.load("visualization", "1", {packages:["corechart"]});
	  
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
		 
		 var jsonData2;
		$.getJSON("data2.json",function(data){
		 jsonData2 = data;
		 console.log(jsonData2);
		 });
		 
		 var data2=[];			
	
	function drawChart() {	

		for(var i = 0; i<jsonData1.length; i++){
			data1.push(jsonData1[i]);
		}
		
		for(var i = 0; i<jsonData2.length; i++){
			data2.push(jsonData2[i]);
		}		
		
		var data3 = new google.visualization.arrayToDataTable(data1);	
		var data4 = new google.visualization.arrayToDataTable(data2);
      
        var options = { title: 'Revenue and cost diff ',			
                       'width':1000,
                       'height':500,
					  };

					  
	//var chart1 = new google.visualization.PieChart(document.getElementById('piechart_before'));
	//var chart2 = new google.visualization.PieChart(document.getElementById('piechart_after'));
    var chartDiff = new google.visualization.PieChart(document.getElementById('piechart_diff'));

    //chart1.draw(data3, options);
    //chart2.draw(data4, options);

    var diffData = chartDiff.computeDiff(data3, data4);
    chartDiff.draw(diffData, options);
        // Instantiate and draw our chart, passing in some options.
       	
		
	  }
	 
 
	   
	 