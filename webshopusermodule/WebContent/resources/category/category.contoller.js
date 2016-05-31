(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("categoryController",['$location','$scope','$routeParams','ngDialog','CategoryService',
	                       function($location,$scope, $routeParams, ngDialog, CategoryService){
		
		$scope.categoryList = getAllCategories();
		 $scope.category = {};
		 $scope.filterValue;
		
		
		$scope.editCategory = function(id){
				$location.path('/category/'+id);
		}
		
		function getAllCategories(){
			 CategoryService.getAllCategories(function(response) {
				$scope.categoryList = response;
	         });
		}
	}]);
	
})();