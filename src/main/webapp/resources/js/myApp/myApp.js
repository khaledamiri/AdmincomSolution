var app = angular.module('myBanqueApp', []);

app.controller('myBanqueController',function($scope, $http) {
	
var urlBase = "http://localhost:8095/AdmincomSolution";
$scope.toggle = true;
$scope.selection = [];
$scope.statuses = [ 'ACTIVE', 'COMPLETED' ];
$scope.priorities = [ 'HIGH', 'LOW', 'MEDIUM' ];
$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";


// get all tasks and display initially
$http.get(urlBase + '/taxes').success(function(data) {
	$scope.tasks = data;
//	for (var i = 0; i < $scope.tasks.length; i++) {
//		if ($scope.tasks[i].taskStatus == 'COMPLETED') {
//			$scope.selection.push($scope.tasks[i].taskId);
//		}
//	}
});




});
