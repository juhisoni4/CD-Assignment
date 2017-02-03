(function() {
	app.controller("myController", myController);	
	myController.$inject = [ "$scope", "$http"];
	
	function myController($scope, $http) {
		var url = "test/exportexcel";
		console.log("In controller");
		
		$scope.exportFile = function(){	
			console.log("In Export Function");			
			window.open(url,'_self', 'toolbar=0,location=0,menubar=0');	
		};
		
		
		$scope.import = function(){
		$http({
            method: 'POST',
            url: 'http://localhost:8080/FinancialReportingTool/test/list',
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            data: {
            	 upload: $scope.file
            },
            transformRequest: function (data, headersGetter) {
                var formData = new FormData();
                angular.forEach(data, function (value, key) {
                    formData.append(key, value);
                });
                var headers = headersGetter();
                delete headers['Content-Type'];
                return formData;
            }            
		})
		 .success(function (data) {
			console.log(data);
			var data1 = data;
			console.log(data1);
			console.log(data1[0]);
			console.log(data1[1]);	

			Morris.Donut({
			  element: 'donut-example',
			  data: [
			    {label: "Error Records", value: data1[1]},
			    {label: "Correct Records", value: data1[0]},		
			    {label: "Total Records", value: data1[2]}		
			  ]
			});			
			 if(data1[1] === 0){
				 alert("done!!"); 
				 console.log(data1[0]);
				 console.log(data1[1]);
			 }else if(data1[0] === undefined){
				 alert('Please import only xls, csv and xlsx file');				 
			 }
			 else{
				alert('There is an error in import file please click on the download button!');			
			 }			
	        }).error(function(data){
	        	console.log("Error");
	        });     
		};	
	};
})();
				
