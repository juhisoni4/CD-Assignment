 google.charts.load('current', {'packages':['scatter']});
      google.charts.setOnLoadCallback(drawChart);
	  
	  var jsonData;
	  $.getJSON("data1.json",function(data){
		jsonData = data;
	  });
	  var data1 = [];
	  
      function drawChart() {
	  
		 for (var i = 0; i < jsonData.length; i++){
			data1.push(jsonData[i]);
		}
		  var data2 = google.visualization.arrayToDataTable(data1);

         var options = {
          width: 1000,
          height: 500,
          chart: {
            title: 'Resources Cost, Revenue and Margin',
            subtitle: 'based on hours'
          },
          hAxis: {title: 'Resources'},
          vAxis: {title: 'Revenue'}
        };        

        var chart = new google.charts.Scatter(document.getElementById('chart_div'));

        chart.draw(data2, google.charts.Scatter.convertOptions(options));
      }