(function() {
	app.controller("myController", myController);	
	myController.$inject = [ "$scope", "$http"];
	
	function myController($scope, $http) {
		console.log("In controller");
		$http.get("http://localhost:8080/FinancialReportingTool/test/list")
		.success(function(data) {
					$scope.revenue = data;
				});
		};	
})();
				