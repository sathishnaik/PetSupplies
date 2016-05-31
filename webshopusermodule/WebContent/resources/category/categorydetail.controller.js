(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("categoryDetailController",['$scope','$location','$routeParams','CategoryService',
	                       function($scope, $location,$routeParams, CategoryService){
		
		$scope.category={};
		$scope.categoryProductList=[];
		var fileName;
		  CategoryService.getCategoryById($routeParams.id,function(response) {
			 $scope.category = response
			 $scope.categoryProductList = $scope.category.products;
         });
		  
			$scope.viewProduct = function(id){
				$location.path('/product/'+id);
				}
	}]);
})();