<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
    
	function drawChart() {
	      // Create the data table.
        var data1 = new google.visualization.DataTable();
		data1.addColumn('string', 'Month');
		data1.addColumn('number', 'Revenue');
		
		$.getJSON( "data1.json", function( data ) {		
			var data2 = data;
			console.log(data2);
			for (var i = 1; i < data2.length; i++)
            data1.addRow(data2[i]);  
		
		});
		
		
		 console.log(data1);
		         
        var options = {'title':'Revenue of Anand Shah',
                       'width':1000,
                       'height':500};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data1, options);
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>

  </body>
  
</html>