var cs480App = angular.module('cs480App', []);

cs480App.controller('ResultsCtrl', function ($scope, $http) {
	$scope.searchById = function(){
 		$http.get("search/id")
 			.success(function(data){
 				$scope.foundUsers = data;
 				});
 	}
 	$scope.searchById();
  });
