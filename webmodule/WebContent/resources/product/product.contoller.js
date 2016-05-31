(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("productController",['$location','$scope','$http','ngDialog','ProductService',
	                     function($location,$scope,$http,ngDialog, ProductService){

		$scope.productList = getAllProducts();
		$scope.itemToDeleteId;
		
		$scope.editProduct = function(id){
			$location.path('/product/'+id);
			}
		
		$scope.openModal = function (itemId) {
		    $scope.itemToDeleteId = itemId;
		    ngDialog.openConfirm({
		    	template: 'modalDialogId',
		    	className: 'ngdialog-theme-default',
				scope: $scope //Pass the scope object if you need to access in the template
				})
			};
		
		$scope.deleteProduct = function () {
			ProductService.deleteProduct($scope.itemToDeleteId).success(function (data) {
				$scope.productList = getAllProducts();
                $scope.status = 'Deleted Product! Refreshing Product list.';
            }).error(function (error) {
                $scope.status = 'Unable to delete Product: ' + error.message;
            });
		    };
		
		function getAllProducts(){
			 ProductService.getAllProducts(function(response) {
				$scope.productList = response;
	         });
			}
	}]);
	
})();