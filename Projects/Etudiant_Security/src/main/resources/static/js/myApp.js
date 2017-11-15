var myApp=angular.module("myApp",[]);

/*
 * Inscription Etudiant
 */
myApp.controller("InscriptionController", function($scope,$http) {
$scope.etudiant={};
$scope.errors=null;
$scope.saveEtudiant=function(){
	$http.post("etudiants",$scope.etudiant)
	.success(function(data) {
		if(!data.errors)
			{
				$scope.etudiant=data;
				$scope.errors=null;
			}
		else{
			$scope.errors=data;			
		}
	});
};
});

/*
 * Liste Controller
 */
myApp.controller("ListEtudiantController",function($scope,$http){
	$scope.PageEtudiant=null;
	$scope.PageCurrent=0;
	$scope.size=5;
	$scope.getListEtudiant=function()
	{
		$http.get("etudiants?page="+$scope.PageCurrent+"&size="+$scope.size)
		.success(function(data) {
			$scope.PageEtudiant=data;
		});
	};
	$scope.getListEtudiant();
});

myApp.controller("IndexController",function($scope,$http){
	
	$scope.menus=["Inscription","Listes Etudiant","Utilisateur","Logout"];
	
});