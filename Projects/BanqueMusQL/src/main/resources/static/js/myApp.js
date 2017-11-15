var app=angular.module("myBanqueApp",[]);
app.controller("myBanqueController", function($scope,$http) {
	$scope.compte=null;
	$scope.codeCompte=null;
	$scope.pageOperations=[];
	$scope.operation={type:"versement",montant:0};
	$scope.errors=null;
	$scope.pageCurrent=0;
	$scope.pageTotal=null;
	$scope.searchCompte=function()
	{
		$http.get("/comptes/"+$scope.codeCompte)
		.success(function(data) {
			$scope.compte=data;
			$scope.operations();
		});
	};
	
	$scope.goTo=function(index)
	{
		$scope.pageCurrent=index;
		$scope.operations();
	}
	
	$scope.operations=function()
	{
		$http.get("/operations?code="+$scope.codeCompte+"&page="+$scope.pageCurrent+"&size=3")
		.success(function(data) {
			$scope.pageTotal=new Array(data.totalpages);
			$scope.pageOperations=data;
		});
	};
	$scope.operationValider=function()
	{
		$http({
			method:'PUT',
			url: $scope.operation.type,
			data:"code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmpl="+$scope.compte.employe.codeEmploye,
			headers:{'Content-Type': "application/x-www-form-urlencoded"}
		}).success(function() {
			$scope.searchCompte();
			$scope.operations();
		}).error(function(data){
			console.log(data);
			$scope.errors={
				message:data.message
			};
		});
	};
});