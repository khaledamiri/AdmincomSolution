var app = angular.module("myBanqueApp", []);

app.controller("myBanqueController",function($scope, $http) {
	
var urlBase = "http://localhost:8095/AdmincomSolution";
$scope.toggle = true;
$scope.selection = [];
$scope.statuses = [ 'ACTIVE', 'COMPLETED' ];
$scope.priorities = [ 'HIGH', 'LOW', 'MEDIUM' ];
$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
$scope.taxes=null;


$http.get(urlBase+"/taxes")
.success(function(data) {
	$scope.taxes = data;
console.log('ok');
})
.error(function(err) {
	
	console.log('ko');
	});




});
