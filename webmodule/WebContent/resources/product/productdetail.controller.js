(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("productDetailController",['$scope','$routeParams','ProductService','CategoryService',
	                       function($scope, $routeParams, ProductService, CategoryService){
		
		$scope.product={};
		var fileName;
		$scope.categoryList = getAllCategories();
		
		ProductService.getProductById($routeParams.id, function(product) {
			 $scope.product = product;
			
			 CategoryService.getCategoryById(product.categoryId, function(categoryresponse) {
				 $scope.product.category = categoryresponse;
		         });
         });
		
		  $scope.saveProduct = function(product){
			 if(!angular.isUndefined(fileName)){
				 product.productImagePath = fileName;
			 }
			  ProductService.saveProduct(product).success(function (data) {
				  $scope.status = 'Product saved successfully!';
	                $scope.product.push(data);
		            }).error(function (error) {
		                $scope.status = 'Unable to save Product: ' + error.message;
		            });
				}
		  
		  $scope.file_changed = function(element) {
			     $scope.$apply(function(scope) {
			         var photofile = element.files[0];
			         fileName=photofile.name;
			         var reader = new FileReader();
			         reader.onload = function(e) {
			            // handle onload
			         };
			         reader.readAsDataURL(photofile);
			     });
			};
			
			$scope.category_changed = function(categoryId){
				 CategoryService.getCategoryById(categoryId, function(categoryresponse) {
					 $scope.product.category = categoryresponse;
			         })
			}
		  
		  function getAllCategories(){
				 CategoryService.getAllCategories(function(response) {
					$scope.categoryList = response;
		         });
			}
		 
	}]);
})();