var app = angular.module("myBanqueApp", []);

app.controller("myBanqueController",function($scope, $http) {
	
var urlBase = "http://localhost:8095/AdmincomSolution";
$scope.toggle = true;
$scope.selection = [];
$scope.types = [ "TVA", "IR" ];
$scope.priorities = [ 'HIGH', 'LOW', 'MEDIUM' ];
$http.defaults.headers.post["Content-Type"] = "application/json";
$scope.taxes=null;
$scope.pages=[];
$scope.pageTaxes=null;
$scope.pageCourante=0;
$scope.size=4;
$scope.selectedType=null;
$scope.numero=100;

$scope.chargerTaxes=function() {
	$http.get("http://localhost:8095/AdmincomSolution/taxesPage?page="+$scope.pageCourante+"&size="+$scope.size)
	.success(function(data) {
		$scope.pageTaxes = data.content;
		$scope.pages= new Array(data.totalPages);
		console.log('ok'+data.content);
	})
	.error(function(err) {
		
		console.log('ko');
		});	
};
//liste des taxes
$http.get("http://localhost:8095/AdmincomSolution/taxesPage?page=0&size=4")
.success(function(data) {
	$scope.pageTaxes = data.content;
	$scope.pages= new Array(data.totalPages);
})
.error(function(err) {
	
	console.log('ko');
	});	

$scope.goToPage=function(p) {
	$scope.pageCourante = p;
	$scope.chargerTaxes();
};
//save taxe
//var newuser = { date:$scope.date, montant: $scope.montant, titre:$scope.titre, type:$scope.selectedType };
$scope.saveTaxe=function() {
	
	$http.post("http://localhost:8095/AdmincomSolution/SaveTaxe",
			{
		date:$scope.date,
		montant: $scope.montant,
		titre:$scope.titre,
		type:$scope.selectedType
		}		
	)
	.success(function(data, status, headers) {
		 alert("Taxe added");
         var newTaxeUri = headers()["location"];
         console.log("Might be good to GET " + newTaxeUri + " and append the task.");
        
         
	    
	})
	.error(function (data, status, headers, config){
		$scope.statusMsg = "Owner was not created. An internal error ocurred. Message: "+ JSON.stringify(data);
		$scope.style = "alert-danger";
		return;
	});
};





});
