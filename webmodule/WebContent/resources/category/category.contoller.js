(function () {
    'use strict';

    var angularApp = angular.module("app");
 // Example of how to set default values for all dialogs
  
	
	angularApp.controller("categoryController",['$location','$scope','$routeParams','ngDialog','CategoryService',
	                       function($location,$scope, $routeParams, ngDialog, CategoryService){
		
		$scope.categoryList = getAllCategories();
		 $scope.category = {};
		
		
		$scope.editCategory = function(id){
				$location.path('/category/'+id);
		}
		
		$scope.itemToDeleteId;
		
		$scope.openModal = function (itemId) {
		    $scope.itemToDeleteId = itemId;
		    ngDialog.openConfirm({template: 'modalDialogId',
		    	className: 'ngdialog-theme-default',
				scope: $scope //Pass the scope object if you need to access in the template
				})
		};
		
		$scope.deleteCategory = function () {
			CategoryService.deleteCategory($scope.itemToDeleteId).success(function (data) {
				$scope.categoryList = getAllCategories();
                $scope.status = 'Deleted Category! Refreshing Category list.';
            }).
            error(function (error) {
                $scope.status = 'Unable to delete Category: ' + error.message;
            });
		    };
		
		function getAllCategories(){
			 CategoryService.getAllCategories(function(response) {
				$scope.categoryList = response;
	         });
		}
	}]);
	
})();